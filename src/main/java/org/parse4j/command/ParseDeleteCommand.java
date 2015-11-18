package org.parse4j.command;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpRequestBase;
import org.parse4j.Parse;

public class ParseDeleteCommand extends ParseCommand {

	private String endPoint;
	private String objectId;
	
	public ParseDeleteCommand(String endPoint) {
        this.endPoint = endPoint;
    }

	public ParseDeleteCommand(String endPoint, String objectId) {
	    this.endPoint = endPoint;
        this.objectId = objectId;
	}
	public ParseDeleteCommand(String endPoint, String objectId, boolean useMasterKey) {
		this(endPoint, objectId);
		this.useMasterKey = useMasterKey;
	}

	@Override
	public HttpRequestBase getRequest() {
		String url = Parse.getParseAPIUrl(endPoint)
				+ (objectId != null ? "/" + objectId : "");
		HttpDelete httpdelete = new HttpDelete(url);
		setupHeaders(httpdelete, false);
		return httpdelete;
	}

}
