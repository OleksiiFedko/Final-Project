package com.hotel.model.tags;

import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.RequestDao;
import com.hotel.model.entities.RequestEntity;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenRequestsTag extends TagSupport {

    /**
     * Output all request with open status.
     * @return
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        List<RequestEntity> openedRequests = new ArrayList<>();
        JspWriter out = pageContext.getOut();
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            RequestDao dao = daoFactory.getRequestDao(connection);
            openedRequests = dao.getOpenedRequests();

            for(RequestEntity entity : openedRequests) {
                out.write("<tr>");
                out.write("<form action=\"/controller\" method=\"post\">");
                out.write("<td>" + entity.getRequestId() + "</td>");
                out.write("<td>" + entity.getDateOfArriving() + "</td>");
                out.write("<td>" + entity.getDateOfLeaving() + "</td>");
                out.write("<td>" + entity.getFirstName() + "</td>");
                out.write("<td>" + entity.getSecondName() + "</td>");
                out.write("<td>" + entity.getRoomClass() + "</td>");
                out.write("<td>" + entity.getPassport() + "</td>");
                out.write("<td>" + entity.getEmail() + "</td>");
                out.write("<input type=\"hidden\" name=\"requestId\" value=\"${request.requestId}\"/>");
                out.write("<input type=\"hidden\" name=\"command\" value=\"checkRoomExistence\">");
                out.write("<td>  <button type=\"submit\">Check for existing</button></td>");
                out.write("</form>");
                out.write("</tr>");
            }

            out.flush();
            out.close();
        } catch (SQLException sqlE) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
