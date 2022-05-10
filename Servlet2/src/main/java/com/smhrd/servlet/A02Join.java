package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/A02Join")
public class A02Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// post 방식으로 전송 -> 인코딩
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw_check = request.getParameter("pw_check");
		String gender = request.getParameter("gender");
		String blood_type = request.getParameter("blood_type");
		String date = request.getParameter("date");
		String[] hobbies = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String textarea = request.getParameter("textarea");
		
		// "아직도 \n 엔터 안되지롱"
		String newtext = textarea.replace("\n", "<br>");
		

		// 돌려주기 위해서 돌려줄 페이지 설정
		response.setContentType("text/html; charset = UTF-8");

		// 출력스트림, 값을 출력하기 위한 통로
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("아이디 : " + id);
		out.print("<br>");
		out.print("비밀번호 : " + pw);
		out.print("<br>");

		if (pw.equals(pw_check)) {
			out.print("비밀번호가 일치합니다.");
		} else {
			out.print("비밀번호가 일치하지 않습니다.");
		}
		out.print("<br>");
		out.print("성별 : " + gender);
		out.print("<br>");
		out.print("혈액형 : " + blood_type);
		out.print("<br>");
		out.print("생일 : " + date);
		out.print("<br>");
		for (String h : hobbies) { // 확장 for문 (for~each 문) - 배열, 어레이리스트 다룰때 유용
			out.print(h + " ");
		}
		out.print("<br>");
		out.print("좋아하는 색 : " + color);
		out.print("<br>");
		out.print("남기고 싶은 말 : " + newtext);
		out.print("</body>");
		out.print("</html>");
	}

}
