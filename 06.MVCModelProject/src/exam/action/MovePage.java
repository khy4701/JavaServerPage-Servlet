package exam.action;

public class MovePage {

	private String pageName;    // 이동 페이지 이름
	private boolean isRedirect; // True : Redirect , False : Foward
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
