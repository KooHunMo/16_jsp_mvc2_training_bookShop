package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.ManagerDto;
import bookshop.controller.CommandAction;
import bookshop.dao.ManagerDao;


public class _08_BookUpdate implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {
			
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_kind = request.getParameter("book_kind");
		
		//DB연동 book_id에 해당하는 상품을 얻내서 book에 저장
		ManagerDao bookProcess = ManagerDao.getInstance();
		ManagerDto book =  bookProcess.getBook(book_id);
		
		request.setAttribute("book_id", book_id);
		request.setAttribute("book_kind", book_kind);
        request.setAttribute("book", book);
		request.setAttribute("type", new Integer(0));
		
		return "/08_bookUpdate.jsp";
		
	}
}