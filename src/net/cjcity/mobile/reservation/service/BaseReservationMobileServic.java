package net.cjcity.mobile.reservation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.cjcity.mobile.reservation.entity.BaseCriteria;
import net.cjcity.mobile.reservation.entity.PageList;
import net.cjcity.mobile.reservation.entity.ReservationOrgan;
import net.cjcity.mobile.reservation.entity.ReservationProgram;
import net.cjcity.mobile.reservation.entity.ReservationReceipt;

import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class BaseReservationMobileServic implements ReservationMobileService {
	static private String siteUrl = "http://www.cjcity.net";
	static private String organUrl = siteUrl+"/reservation/organList.cj?ajaxRequest=true";
	static private String programUrl = siteUrl+"/reservation/programList.cj?ajaxRequest=true";
	static private String receiptUrl = siteUrl+"/reservation/receiptList.cj?ajaxRequest=true";
	private String imagePath;
	private PageList organList;
	private PageList programList;
	private PageList receiptList;
	
	private String[] datePattern = {"yyyy.MM.dd HH:mm"};
	
	private static ReservationMobileService self;
	static{
		self = new BaseReservationMobileServic();
	}
	public static ReservationMobileService getInstance() {
		return self; 
	}
	
	@Override
	public PageList getOrgans(BaseCriteria criteria) {
		InputStream isText = null;
		JSONArray jsonArray;
		StringBuilder sb;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		
		Log.i("Net", "NameForList ====> "+criteria.getNameForList());
		
		try {
			URL url = createOrganUrl(criteria);
			Log.i("Net", "created URL ====> "+url.toString());
			conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					sb = new StringBuilder();
					br = new BufferedReader(new InputStreamReader(
							conn.getInputStream()));
					for (;;) {
						String line = br.readLine();
						if (line == null)
							break;
						sb.append(line);
					}

					// realStr = realStr.substring(realStr.indexOf("["),
					// realStr.lastIndexOf("]")+1);
					// TextView tv = (TextView) findViewById(R.id.text01);
					// tv.setText("결과 : \n"+realStr);
					System.err.println(sb.toString());
					// json 처리
					JSONObject origianl = new JSONObject(sb.toString());
					jsonArray = origianl.getJSONArray("list");
					if (this.imagePath == null
							|| "".equals(this.imagePath.trim()))
						this.imagePath = origianl.getString("imgPath");
					List<ReservationOrgan> organs = new ArrayList<ReservationOrgan>();
					JSONObject json;
					ReservationOrgan organ;
					for (int i = 0; i < jsonArray.length(); i++) {
						json = jsonArray.getJSONObject(i);
						organ = new ReservationOrgan();
						organ.setId(json.getInt("id"));
						organ.setName(json.getString("name"));
						organ.setDetail(escapeHtml(json.getString("detail")));
						organ.setImage(getImage(json.getString("thumbnail")));
						organs.add(organ);
					}
					PageList plist = new PageList(organs, jsonArray.length(),
							criteria.getPage(), criteria.getPageSize());
					this.organList = plist;
					return plist;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception e) {
				}
			}

		}// end try~catch~finally
		return null;
	}

	private String escapeHtml(String html) {
//		'#', '%', '\', '?' should be replaced by %23, %25, %27, %3f respectively.
		if(html==null)return "";
		html = html.replace("#", "%23");
		html = html.replace("%", "%25");
		html = html.replace("\\", "%27");
		html = html.replace("?", "%3f");
		return html;
	}

	//기관 획득 주소
	private URL createOrganUrl(BaseCriteria criteria) throws MalformedURLException, UnsupportedEncodingException {
		String rtnUrl = organUrl;
		if(!criteria.getNameForList().equals(""))
			rtnUrl += "&nameForList="+encodingParam(criteria.getNameForList(), "UTF-8");
		
		return new URL(rtnUrl);
	}
	
	//프로그램 획득 주소
	private URL createProgramUrl(BaseCriteria criteria) throws MalformedURLException, UnsupportedEncodingException {
		String rtnUrl = programUrl;
		if(!criteria.getNameForList().equals(""))
			rtnUrl += "&nameForList="+encodingParam(criteria.getNameForList(), "UTF-8");
		if(!criteria.getSearchPk3().equals(""))	//기관 아이디
			rtnUrl += "&searchPk3="+criteria.getSearchPk3();
		
		return new URL(rtnUrl);
	}

	//접수 획득 주소
	private URL createReceiptUrl(BaseCriteria criteria) throws MalformedURLException, UnsupportedEncodingException {
		String rtnUrl = receiptUrl;
		if(!criteria.getSearchPk4().equals(""))	//프로그램 아이디
			rtnUrl += "&searchPk4="+criteria.getSearchPk4();
		rtnUrl += "&searchKey3=Y";
		
		return new URL(rtnUrl);
	}

	//파람 인코딩
	private String encodingParam(String target, String enc) throws UnsupportedEncodingException{
		String rtnString = "";
		if(!target.equals(""))
			rtnString = URLEncoder.encode(target, enc);
		
		return rtnString;
	}
	
	
	private Bitmap getImage(String imageName) {
		if(imageName==null||"".equals(imageName.trim()))
			return null;
    	URL imgSrc = null;
		InputStream is = null;
		Bitmap mBitmap =null;
		try {
			imgSrc = new URL(siteUrl+this.imagePath+imageName);
			is = imgSrc.openStream();
			mBitmap = BitmapFactory.decodeStream(is);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is!=null){
				try {is.close();} catch (IOException e) {}
			}					
		}//end try~catch~finally	
		return mBitmap;
	}

	private URL createUrl() throws MalformedURLException {
		return new URL(organUrl);
	}

	@Override
	public ReservationOrgan getOrgan(Integer organId) {
		for (Iterator iterator = this.organList.iterator(); iterator.hasNext();) {
			ReservationOrgan organ  = (ReservationOrgan) iterator.next();
			if(organ.getId().equals(organId))return organ;
		}
		return null;
	}
	@Override
	public ReservationOrgan getNextOrgan(Integer organId) {
		try{
			for (int i = 0; i < this.organList.size(); i++) {
				ReservationOrgan organ  = (ReservationOrgan) this.organList.get(i);
				if(organ.getId().equals(organId)){
					return (ReservationOrgan) this.organList.get(i-1);
				}
			}
		}catch(Exception e){}
		return null;
	}
	@Override
	public ReservationOrgan getPrevOrgan(Integer organId) {
		try {
			for (int i = 0; i < this.organList.size(); i++) {
				ReservationOrgan organ  = (ReservationOrgan) this.organList.get(i);
				if(organ.getId().equals(organId)){
					return (ReservationOrgan) this.organList.get(i+1);
				}
			}
		} catch (Exception e) {		}
		return null;
	}

	@Override
	public PageList getPrograms(BaseCriteria criteria) {
		Log.i("Net", "get Programs Here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		InputStream isText = null;
		JSONArray jsonArray;
		StringBuilder sb;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL url = createProgramUrl(criteria);
			conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					sb = new StringBuilder();
					br = new BufferedReader(new InputStreamReader(
							conn.getInputStream()));
					for (;;) {
						String line = br.readLine();
						if (line == null)
							break;
						sb.append(line);
					}

					// realStr = realStr.substring(realStr.indexOf("["),
					// realStr.lastIndexOf("]")+1);
					// TextView tv = (TextView) findViewById(R.id.text01);
					// tv.setText("결과 : \n"+realStr);
					System.err.println(sb.toString());
					// json 처리
					JSONObject origianl = new JSONObject(sb.toString());
					jsonArray = origianl.getJSONArray("list");
					if (this.imagePath == null
							|| "".equals(this.imagePath.trim()))
						this.imagePath = origianl.getString("imgPath");
					List<ReservationProgram> programs = new ArrayList<ReservationProgram>();
					JSONObject json;
					ReservationProgram program;
					for (int i = 0; i < jsonArray.length(); i++) {
						json = jsonArray.getJSONObject(i);
						program = new ReservationProgram();
						program.setId(json.getInt("id"));
						program.setName(json.getString("name"));
						program.setExplain(escapeHtml(json.getString("explain")));
						program.setImage(getImage(json.getString("thumbnail")));
						programs.add(program);
					}
					PageList plist = new PageList(programs, jsonArray.length(),
							criteria.getPage(), criteria.getPageSize());
					this.programList = plist;
					return plist;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception e) {
				}
			}

		}// end try~catch~finally
		return null;
	}

	@Override
	public ReservationProgram getProgram(Integer programId) {
		for (Iterator iterator = this.programList.iterator(); iterator.hasNext();) {
			ReservationProgram program  = (ReservationProgram) iterator.next();
			if(program.getId().equals(programId)) return program;
		}
		return null;
	}	
	@Override
	public ReservationProgram getNextProgram(Integer programId) {
		try{
			for (int i = 0; i < this.programList.size(); i++) {
				ReservationProgram program  = (ReservationProgram) this.programList.get(i);
				if(program.getId().equals(programId)){
					return (ReservationProgram) this.programList.get(i-1);
				}
			}
		}catch(Exception e){}
		return null;
	}
	@Override
	public ReservationProgram getPrevProgram(Integer programId) {
		try {
			for (int i = 0; i < this.programList.size(); i++) {
				ReservationProgram program  = (ReservationProgram) this.programList.get(i);
				if(program.getId().equals(programId)){
					return (ReservationProgram) this.programList.get(i+1);
				}
			}
		} catch (Exception e) {		}
		return null;
	}

	@Override
	public PageList getReceipts(BaseCriteria criteria) {
		Log.i("Net", "get Receipts Here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		InputStream isText = null;
		JSONArray jsonArray;
		StringBuilder sb;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL url = createReceiptUrl(criteria);
			conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					sb = new StringBuilder();
					br = new BufferedReader(new InputStreamReader(
							conn.getInputStream()));
					for (;;) {
						String line = br.readLine();
						if (line == null)
							break;
						sb.append(line);
					}

					// realStr = realStr.substring(realStr.indexOf("["),
					// realStr.lastIndexOf("]")+1);
					// TextView tv = (TextView) findViewById(R.id.text01);
					// tv.setText("결과 : \n"+realStr);
					System.err.println(sb.toString());
					// json 처리
					JSONObject origianl = new JSONObject(sb.toString());
					jsonArray = origianl.getJSONArray("list");
					if (this.imagePath == null
							|| "".equals(this.imagePath.trim()))
						this.imagePath = origianl.getString("imgPath");
					List<ReservationReceipt> receipts = new ArrayList<ReservationReceipt>();
					JSONObject json;
					ReservationReceipt receipt;
					for (int i = 0; i < jsonArray.length(); i++) {
						json = jsonArray.getJSONObject(i);
						receipt = new ReservationReceipt();
						receipt.setId(json.getInt("id"));
						receipt.setName(json.getString("name"));
						receipt.setAcceptingMethod(json.getString("acceptingMethod"));
						
						SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
						try {
							Date receiptStartDate = df.parse(json.getString("receiptStartDate"));
							Date receiptEndDate = df.parse(json.getString("receiptEndDate"));
							Date attendingStartDate = df.parse(json.getString("attendingStartDate"));
							Date attendingEndDate = df.parse(json.getString("attendingEndDate"));
							
							receipt.setReceiptStartDate(receiptStartDate);
							receipt.setReceiptEndDate(receiptEndDate);
							receipt.setAttendingStartDate(attendingStartDate);
							receipt.setAttendingEndDate(attendingEndDate);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						receipts.add(receipt);
					}
					PageList plist = new PageList(receipts, jsonArray.length(),
							criteria.getPage(), criteria.getPageSize());
					this.receiptList = plist;
					return plist;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception e) {
				}
			}

		}// end try~catch~finally
		return null;
	}

	@Override
	public ReservationReceipt getReceipt(Integer organId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String getImageUrl(ReservationOrgan organ){
		String imageUrlString = siteUrl+this.imagePath+organ.getOzcdName();
		return null;
		
	}
	
}
