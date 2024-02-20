package com.asule.action;



import com.asule.application.bean.MemberBean;
import com.asule.application.model.Member;
import com.asule.database.Database;
import com.asule.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/members")
public class ActiveMembers extends HttpServlet {

    public String displayNavAndMembers(){
        return (
                "  <head>\n" +
                        "    <meta charset=\"UTF-8\" />\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                        "    <title>Members</title>\n" +
                        "  </head>\n" +
                        "  <style>\n" +
                        "    * {\n" +
                        "      margin: 0;\n" +
                        "      padding: 0;\n" +
                        "      box-sizing: border-box;\n" +
                        "    }\n" +
                        "    body {\n" +
                        "      width: 100%;\n" +
                        "      height: 90vh;\n" +
                        "      font-family: \"Mona Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n" +
                        "      font-size: 15px;\n" +
                        "    }\n" +
                        "    .navbarContainer{\n" +
                        "        width: 83%;\n" +
                        "        margin: auto;\n" +
                        "       padding: 20px 0px;\n" +
                        "    }\n" +
                        "    .title{\n" +
                        "        font-size: 1.2rem;\n" +
                        "\n" +
                        "    }\n" +
                        "    .title a{\n" +
                        "        color:  rgb(0, 53, 133);\n" +
                        "        text-decoration: none;\n" +
                        "        font-weight: 600;\n" +
                        "    }\n" +
                        "    .navClass{\n" +
                        "        display: flex;\n" +
                        "        justify-content: space-between;\n" +
                        "        width: 100%;\n" +
                        "        align-items: center;\n" +
                        "    }\n" +
                        "    .links{\n" +
                        "        display: flex;\n" +
                        "        gap: 40px;\n" +
                        "        \n" +
                        "    }\n" +
                        "    .links,a{\n" +
                        "        color: #272829;\n" +
                        "        text-decoration: none;\n" +
                        "        \n" +
                        "    }\n" +
                        "    .links a:hover{\n" +
                        "        color:  rgb(0, 53, 133);\n" +
                        "        \n" +
                        "    }\n" +
                        "    .contactButton{\n" +
                        "        border:1px rgb(0, 53, 133) solid;\n" +
                        "        padding: 8px 17px;\n" +
                        "        border-radius: 25px;  \n" +
                        "        color: rgb(0, 53, 133);      \n" +
                        "    }\n" +
                        "    .contactButton a{\n" +
                        "        text-decoration: none;\n" +
                        "        color: rgb(0, 53, 133);    \n" +
                        "    }\n" +
                        "    .contactButton a:hover{\n" +
                        "        color: white;   \n" +
                        "    }\n" +
                        ".lastPart{\n" +
                        "        display: flex;\n" +
                        "        align-items: center;\n" +
                        "        gap: 30px;\n" +
                        "    }\n" +
                        "    .profile{\n" +
                        "        padding: 12px 15px;\n" +
                        "        border-radius: 50%; \n" +
                        "        border:none;\n" +
                        "        background-color: rgb(10, 79, 182) ;\n" +
                        "        color: white;\n" +
                        "        font-weight: 600;\n" +
                        "    }" +
                        "    .contactButton:hover{\n" +
                        "        /* border:none; */\n" +
                        "        background-color: rgb(10, 79, 182) ;\n" +
                        "        color: white;\n" +
                        "        cursor: pointer;\n" +
                        "    }\n" +
                        "    .outlineTicketButton{\n" +
                        "        border:1px rgb(0, 53, 133) solid;\n" +
                        "        padding: 10px 20px;\n" +
                        "        border-radius: 25px;  \n" +
                        "        color: rgb(0, 53, 133);      \n" +
                        "    }\n" +
                        "    .outlineTicketButton:hover{\n" +
                        "        /* border:none; */\n" +
                        "        background-color: rgb(10, 79, 182) ;\n" +
                        "        color: white;\n" +
                        "        cursor: pointer;\n" +
                        "    }\n" +
                        "  \n" +
                        "    .topPart {\n" +
                        "      height: 170px;\n" +
                        "      background: rgb(28, 85, 172);\n" +
                        "      margin-bottom: 30px;\n" +
                        "      display: flex;\n" +
                        "      align-items: center;\n" +
                        "    }\n" +
                        "    .topPartTitle{\n" +
                        "        width: 70%;\n" +
                        "        margin: auto;\n" +
                        "    }\n" +
                        "    .topPartTitle p{\n" +
                        "        color: white;\n" +
                        "        font-size: 2.5rem;\n" +
                        "        font-weight: 600;\n" +
                        "        font-style: italic;\n" +
                        "    }\n" +
                        "    .fixtureContainer {\n" +
                        "      width: 70%;\n" +
                        "      margin: auto;\n" +
                        "    }\n" +
                        "    .oneFixture {\n" +
                        "      display: flex;\n" +
                        "      justify-content: space-between;\n" +
                        "      align-items: center;\n" +
                        "      padding: 18px 0px;\n" +
                        "      color: #272829;\n" +
                        "      border-bottom: 1px solid #7c7c7c;\n" +
                        "    }\n" +
                        "    .oneFixture:hover {\n" +
                        "      cursor: pointer;\n" +
                        "      background-color: rgb(238, 238, 238);\n" +
                        "      padding: 18px 5px;\n" +
                        "      color: black;\n" +
                        "    }\n" +
                        "    .teams {\n" +
                        "      display: flex;\n" +
                        "      flex-direction: column;\n" +
                        "      gap: 7px;\n" +
                        "    }\n" +
                        "  </style>"
                );
    };

    public  void doGet(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException{
        HttpSession httpSession = req.getSession();
        Cookie userCookie = CookieUtils.getCookieByName(req, "username");
        String accessCookie = null;
        String firstLetter = null;

        if (userCookie != null) {
            accessCookie = userCookie.getValue();
            firstLetter = accessCookie.substring(0, 1).toUpperCase();
        } else {
            System.out.println("Cookie not found");
        }

        if(StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))){
            PrintWriter print = res.getWriter();
            print.write("<!DOCTYPE html>\n" +
            "<html lang=\"en\">" +
            displayNavAndMembers() +
            "<body>\n" +
            "  <div class=\"navbarContainer\" >\n" +
                    "        <nav class=\"navClass\">\n" +
                    "            <div class=\"title\">\n" +
                    "                <a href=\"/\">Ajay Fitness</a>\n" +
                    "            </div>\n" +
                    "            <div class=\"links\" >\n" +
                    "               <a href=\"./home\">HOME</a>\n" +
                    "               <a href=\"./members\">MEMBERS</a>\n" +
                    "               <a href=\"./register\">REGISTRATION</a>\n" +
                    "            </div>\n" +
                    " <div class=\"lastPart\">\n" +
                    "          <p class=\"profile\" >  " +
                    firstLetter +
                    "</p>\n" +
                    "          <a href=\"./logout\" class=\"contactButton\"> LOGOUT </a>\n" +
                    "        </div>" +
                    "        </nav>\n" +
                    "    </div>" +
                    " <div class=\"mainContainer\">\n" +
                    "      <!-- top part -->\n" +
                    "      <div class=\"topPart\">\n" +
                    "        <div class=\"topPartTitle\">\n" +
                    "          <p> New Members</p>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "      <!-- bottom part  -->\n" +
                    "      <div class=\"memberContainer\">");
                   // Assuming MemberBean.memberbean() returns a String[]
String[] memberBeanArray = MemberBean.memberbean();

// Iterate over the array and write each element to the PrintWriter
for (String element : memberBeanArray) {
    print.write(element);
}



            print.write(
                    " </div>\n" +
                            "    </div>"+
                            "</body>\n" +
                    //body
                    "</html>"
        );
        }else{
            res.sendRedirect("./");
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
     

        Cookie userCookie = CookieUtils.getCookieByName(req, "username");
        String accessCookie = null;
        String firstLetter = null;

        if (userCookie != null) {
            accessCookie = userCookie.getValue();
            firstLetter = accessCookie.substring(0, 1).toUpperCase();
        } else {
            System.out.println("Cookie not found");
        }


// Assuming 'database' is an instance of your Database class
Database database = Database.getDbInstance();

// Get the input parameters
String memberName = req.getParameter("memberName");
String memberId = req.getParameter("memberId");
String startingDate = req.getParameter("startingDate");

// Check for null values in input parameters
if (memberName != null && memberId != null && startingDate != null) {

    // Ensure that the list returned by getMember() is initialized
    List<Member> memberList = database.getMember();
    if (memberList != null) {

        // Create and add a new Member to the list
        memberList.add(new Member(memberName, memberId, startingDate));

    } else {
        // Handle the case where 'database.getMember()' is null
    }

} else {
    // Handle the case where any of the input parameters is null
}




        if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
            PrintWriter print = res.getWriter();

            print.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">" +
                    displayNavAndMembers() +
                    "<body>\n" +
                    "  <div class=\"navbarContainer\" >\n" +
                    "        <nav class=\"navClass\">\n" +
                    "            <div class=\"title\">\n" +
                    "                <a href=\"/\">Ajay Fitness</a>\n" +
                    "            </div>\n" +
                    "            <div class=\"links\" >\n" +
                    "               <a href=\"./home\">HOME</a>\n" +
                    "               <a href=\"./members\">MEMBERS</a>\n" +
                    "               <a href=\"./register\">REGISTRATION</a>\n" +
                    "            </div>\n" +
                    " <div class=\"lastPart\">\n" +
                    "          <p class=\"profile\" >  " +
                    firstLetter +
                    "</p>\n" +
                    "          <a href=\"./logout\" class=\"contactButton\"> LOGOUT </a>\n" +
                    "        </div>" +
                    "        </nav>\n" +
                    "    </div>" +
                    " <div class=\"mainContainer\">\n" +
                    "      <!-- top part -->\n" +
                    "      <div class=\"topPart\">\n" +
                    "        <div class=\"topPartTitle\">\n" +
                    "          <p>New members</p>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "      <!-- bottom part  -->\n" +
                    "      <div class=\"member Container\">");

            print.write(
                    " </div>\n" +
                            "    </div>"+
                            "</body>\n" +
                            //body
                            "</html>"
            );

        }
    }
}

