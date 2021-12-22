package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.netflix.zuul.scriptManager.FilterInfo;
import com.netflix.zuul.IZuulFilterDao;
import com.netflix.zuul.ZuulFilterDaoFactory;
import com.netflix.zuul.util.AdminFilterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public final class filterLoader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

    Logger LOG = LoggerFactory.getLogger("filterloader");

    IZuulFilterDao scriptDAO = null;
    try {
        scriptDAO = ZuulFilterDaoFactory.getZuulFilterDao();
    } catch (Exception e) {
        LOG.error(e.getMessage(), e);
    }
    List<String> filterIds = scriptDAO.getAllFilterIds();

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Spring2go Filter Manager</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("UPLOAD\n");
      out.write("<form method=\"POST\" enctype=\"multipart/form-data\" action=\"scriptmanager?action=UPLOAD\">\n");
      out.write("    <input type=\"file\" name=\"upload\" size=\"40\"/>\n");
      out.write("    <input type=\"submit\"/>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("ACTIVE SCRIPTS\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <td>NAME</td>\n");
      out.write("        <td>TYPE</td>\n");
      out.write("        <td>ORDER</td>\n");
      out.write("        <td>DISABLE PROPERTY</td>\n");
      out.write("        <td>CREATE DATE</td>\n");
      out.write("        <td>REVISION</td>\n");
      out.write("        <td>STATE</td>\n");
      out.write("    </tr>\n");
      out.write("    ");


        List<FilterInfo> filters = scriptDAO.getAllActiveFilters();
        for (FilterInfo filter : filters) {
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(filter.getFilterName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterType());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterOrder());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterDisablePropertyName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getCreationDate());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getRevision());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.getState(filter));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildDeactivateForm(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildDownloadLink(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("CANARY SCRIPTS\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <td>NAME</td>\n");
      out.write("        <td>TYPE</td>\n");
      out.write("        <td>ORDER</td>\n");
      out.write("        <td>DISABLE PROPERTY</td>\n");
      out.write("        <td>CREATE DATE</td>\n");
      out.write("        <td>REVISION</td>\n");
      out.write("        <td>STATE</td>\n");
      out.write("    </tr>\n");
      out.write("    ");


        filters = scriptDAO.getAllCanaryFilters();
        for (FilterInfo filter : filters) {
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(filter.getFilterName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterType());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterOrder());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterDisablePropertyName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getCreationDate());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getRevision());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.getState(filter));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildDeactivateForm(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildActivateForm(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildDownloadLink(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("LATEST SCRIPTS\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <td>NAME</td>\n");
      out.write("        <td>TYPE</td>\n");
      out.write("        <td>ORDER</td>\n");
      out.write("        <td>DISABLE PROPERTY</td>\n");
      out.write("        <td>CREATE DATE</td>\n");
      out.write("        <td>REVISION</td>\n");
      out.write("        <td>STATE</td>\n");
      out.write("        <td>Activate</td>\n");
      out.write("        <td>Make Canary</td>\n");
      out.write("\n");
      out.write("    </tr>\n");
      out.write("    ");


        for (String filterID : filterIds) {
            FilterInfo filter = scriptDAO.getLatestFilter(filterID);
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(filter.getFilterName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterType());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterOrder());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterDisablePropertyName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getCreationDate());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getRevision());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.getState(filter));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildActivateForm(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildCanaryForm(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildDownloadLink(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("All SCRIPTS\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <td>NAME</td>\n");
      out.write("        <td>TYPE</td>\n");
      out.write("        <td>ORDER</td>\n");
      out.write("        <td>DISABLE PROPERTY</td>\n");
      out.write("        <td>CREATE DATE</td>\n");
      out.write("        <td>REVISION</td>\n");
      out.write("        <td>STATE</td>\n");
      out.write("        <td>Activate</td>\n");
      out.write("        <td>Make Canary</td>\n");
      out.write("    </tr>\n");
      out.write("    ");


        for (String filterID : filterIds) {
            filters = scriptDAO.getZuulFilters(filterID);
            for (FilterInfo filter : filters) {
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(filter.getFilterName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterType());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterOrder());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getFilterDisablePropertyName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getCreationDate());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(filter.getRevision());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.getState(filter));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildActivateForm(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildCanaryForm(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(AdminFilterUtil.buildDownloadLink(filter.getFilterID(), filter.getRevision()));
      out.write("\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    ");

            }
        }
    
      out.write("\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
