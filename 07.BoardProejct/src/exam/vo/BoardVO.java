package exam.vo;

import java.sql.Date;

public class BoardVO {

	private int num;
	private String id;
	private String name;
	private String title;
	private String content;
	private Date writeDate;
	private String fileName;
	private int readCount;
	private int downCount;
	public int getNum() {
		return num;
	}
	
	public BoardVO()
	{
		
	}
	
	public BoardVO(int num, String id, String name, String title, String content, Date writeDate, String fileName,
			int readCount, int downCount) {
		super();
		this.num = num;
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.fileName = fileName;
		this.readCount = readCount;
		this.downCount = downCount;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getDownCount() {
		return downCount;
	}
	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}
	
	
}
