package fan;

import java.util.List;
import fan.translate;
public class fanbean {
private String from;
private String to;
private List<translate> trans_result;
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public List<translate> getTrans_result() {
	return trans_result;
}
public void setTrans_result(List<translate> trans_result) {
	this.trans_result = trans_result;
}
}
