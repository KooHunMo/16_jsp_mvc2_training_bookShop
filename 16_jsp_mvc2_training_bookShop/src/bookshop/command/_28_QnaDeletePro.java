package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.dao.QnaDao;
import bookshop.controller.CommandAction;

public class _28_QnaDeletePro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int qna_id =  Integer.parseInt(request.getParameter("qna_id"));
		
		//qna_id에 해당하는 qna삭제
		QnaDao qnaProcess = QnaDao.getInstance();
		int check = qnaProcess.deleteArticle(qna_id);
		
		request.setAttribute("check", new Integer(check));
	
		return "/28_qnaDeletePro.jsp";
	
	}
	
}