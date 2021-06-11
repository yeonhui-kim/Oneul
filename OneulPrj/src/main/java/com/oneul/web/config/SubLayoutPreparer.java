package com.oneul.web.config;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class SubLayoutPreparer implements ViewPreparer {

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		
//		Map<String, Object> model = tilesContext.getContext("request");
//		
//		model.put("data", "default data");
//		
//		String title = (String)model.get("title");
//		if(title == null)
//			model.put("title", "뉴렉쳐 온라인");
	}

}
