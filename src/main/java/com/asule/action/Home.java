package com.asule.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger.Level;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import com.asule.utils.CookieUtils;
import com.asule.utils.CustomLogger;

@WebServlet("/home")
public class Home extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
            ServletContext context = getServletContext();
            PrintWriter print = res.getWriter();
            CustomLogger logger = CustomLogger.getLoggerInstance();

            Cookie userCookie = CookieUtils.getCookieByName(req, "username");
            String accessCookie = null;
            String firstLetter = null;

            if (userCookie != null) {
                accessCookie = userCookie.getValue();
                firstLetter = accessCookie.substring(0, 1).toUpperCase();
            } else {
                System.out.println("Cookie not found");
            }

            //System.out.println("********** " + accessCookie + "***************");
            logger.log(Level.INFO, "********** " + accessCookie + "***************");


            print.write(
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                            "    <title>Welcome Page</title>\n" +
                            "</head>\n" +
                            "<style>\n" +
                            "      * {\n" +
                            "      margin: 0;\n" +
                            "      padding: 0;\n" +
                            "      box-sizing: border-box;\n" +
                            "    }\n" +
                            "    body{\n" +
                            "        width: 100%;\n" +
                            "        font-family: \"Mona Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n" +
                            "        font-size: 14px;\n" +
                          
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
                            "    .contactButton:hover{\n" +
                            "        /* border:none; */\n" +
                            "        background-color: rgb(10, 79, 182) ;\n" +
                            "        color: white;\n" +
                            "        cursor: pointer;\n" +
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
                            ".mainContainer {\n" +
                            "      width: 83%;\n" +
                            "      margin: auto;\n" +
                            "      padding-top: 10px;\n" +
                            "      padding-bottom: 10px;\n" +
                            "      display: flex;      \n" +
                            "      justify-content: space-around;\n" +
                            "      height: 83vh;\n" +
                            "      align-items: center;\n" +
                            "      gap: 30px;\n" +
                            "    }\n" +
                            "    .heroSection {\n" +
                            "      width: 50%;\n" +
                            "      display: flex;\n" +
                            "      flex-direction: column;      \n" +
                            "      gap: 20px;\n" +
                            "    }\n" +
                            "    .sectionTitle {\n" +
                            "      font-size: 2.7rem;\n" +
                            "      font-weight: 600;\n" +
                            "      letter-spacing: 2px;\n" +
                            "      line-height: 4rem;\n" +
                            "     \n" +
                            "    }\n" +
                            "    .summary {\n" +
                            "      width: 70%;\n" +
                            "      color: #272829;\n" +
                            "      margin: 13px 0px;\n" +
                            "  \n" +
                            "    }\n" +
                            "    .blueText {\n" +
                            "      color: rgb(0, 53, 133);\n" +
                            "    }\n" +
                            "    .homeNormalButton{\n" +
                            "        padding: 12px 24px;\n" +
                            "        border-radius: 25px; \n" +
                            "        border:none;\n" +
                            "        background-color: rgb(10, 79, 182) ;\n" +
                            "        color: white;\n" +
                            "        cursor: pointer;\n" +
                            "        text-decoration: none;\n" +
                            "    }\n" +
                            "    .homeOutlineButton{\n" +
                            "        border:1px rgb(0, 53, 133) solid;\n" +
                            "        padding: 10px 20px;\n" +
                            "        border-radius: 25px;  \n" +
                            "        color: rgb(0, 53, 133);  \n" +
                            "        text-decoration: none;    \n" +
                            "    }\n" +
                            "    .homeOutlineButton:hover{\n" +
                            "        /* border:none; */\n" +
                            "        background-color: rgb(10, 79, 182) ;\n" +
                            "        color: white;\n" +
                            "        cursor: pointer;\n" +
                            "    }\n" +
                            "    .homeButtons{\n" +
                            "        display: flex;\n" +
                            "        gap: 20px;\n" +
                            "        align-items: center;\n" +
                            "    }\n" +
                            "    .heroImage {\n" +
                            "      width: 50%;\n" +
                            "    }\n" +
                            "    .imageContainer{\n" +
                            "      width: 100%;\n" +
                            "  \n" +
                            "    }\n" +
                            "    .bgImage{\n" +
                            "      width: 100%;\n" +
                            "    }" +
                            " .formMainContainer {\n" +
                            "      width: 83%;\n" +
                            "      margin: auto;\n" +
                            "      padding-top: 10px;\n" +
                            "      padding-bottom: 10px;\n" +
                            "    }\n" +
                            "    .formContainer {\n" +
                            "      width: 600px;\n" +
                            "      display: grid;\n" +
                            "      grid-template-columns: auto auto;\n" +
                            "      gap: 15px;\n" +
                            "      margin: 20px 0px;\n" +
                            "    }\n" +
                            "    .memberTitle {\n" +
                            "      font-size: 1.5rem;\n" +
                            "    }\n" +
                            "\n" +
                            "    .normalFormButton {\n" +
                            "      padding: 12px 24px;\n" +
                            "      border-radius: 25px;\n" +
                            "      border: none;\n" +
                            "      background-color: rgb(10, 79, 182);\n" +
                            "      color: white;\n" +
                            "      cursor: pointer;\n" +
                            "    }\n" +
                            "    .formInput {\n" +
                            "      display: flex;\n" +
                            "      flex-direction: column;\n" +
                            "      gap: 5px;\n" +
                            "      margin: 5px 0px;\n" +
                            "    }\n" +
                            "    .formInput input {\n" +
                            "      padding: 10px;\n" +
                            "      border-radius: 3px;\n" +
                            "      border: 1px solid lightgray;\n" +
                            "    }\n" +
                            "    .formInput input:focus {\n" +
                            "      outline: none;\n" +
                            "    }" +
                            "</style>" +
                            "<body>\n" +
                            "  <div class=\"navbarContainer\" >\n" +
                            "        <nav class=\"navClass\">\n" +
                            "            <div class=\"title\">\n" +
                            "                <a href=\"/\">AjayFitness</a>\n" +
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

                            "  <div class=\"mainContainer\">\n" +
                            "      <div class=\"heroSection\">\n" +
                            "        <div class=\"sectionTitle\">\n" +
                            "          <p>\n" +
                            "            Experience The <br />\n" +
                            "            <span class=\"blueText\">Welcome to Ajay Fitness,  </span> <br />\n" +
                            "            where fitness meets inspiration.\n" +
                            "          </p>\n" +
                            "        </div>\n" +
                            "        <div>\n" +
                            "          <p class=\"summary\">\n" +
                            "            Unleash the power within as you embark on a \n" +
                            "            transformative fitness experience crafted just for you.\n" +
                            "            its a vibrant community \n" +
                            "          </p>\n" +
                            "        </div>\n" +
                            "        <div class=\"homeButtons\">\n" +
                            "            <a href=\"./members\" class=\"homeOutlineButton\" > Our Members</a>\n" +
                            "            <a href=\"./register\" class=\"homeNormalButton\">Registration</a>\n" +
                            "        </div>\n" +
                            "      </div>\n" +
                            "      <div class=\"heroImage\">\n" +
                            "        <div class=\"imageContainer\">\n" +
                            "          <img class=\"bgImage\" src=\"https://wallpapercave.com/wp/wp8916449.jpg\" alt=\"stadium\">" +
                            "        </div>\n" +
                            "      </div>\n" +
                            "    </div>" +
                            " <div class=\"formMainContainer\">\n" +
                            "      <div class=\"registermemberContainer\">\n" +
                            "        <p class=\"MemberTitle\">Member Details</p>\n" +
                            "\n" +
                            "        <form action=\"./members\" method=\"post\">\n" +
                            "          <div class=\"formContainer\">\n" +

                            "            <div class=\"formInput\">\n" +
                            "              <label for=\"MemberName\">Name:</label>\n" +
                            "              <input type=\"text\" name=\"MemberName\" id=\"membername\" />\n" +
                            "            </div>\n" +
                            "            <div class=\"formInput\">\n" +
                            "              <label for=\"MemberID\">ID:</label>\n" +
                            "              <input type=\"text\" name=\"MemberID\" id=\"ID\" />\n" +
                            "            </div>\n" +

                            "            <div class=\"formInput\">\n" +
                            "              <label for=\"StartingDate\">StartingDate:</label>\n" +
                            "              <input type=\"date\" name=\"StartingDate\" id=\"StartingDate\" />\n" +
                            "            </div>\n" +
                            "          </div>\n" +
                            "          <input class=\"normalFormButton\" type=\"submit\" value=\"Register member\" />\n" +
                            "        </form>\n" +
                            "      </div>\n" +
                            "    </div>");

            print.write(
                    "    </div>\n" +
                            "</body>\n" +
                            "</html>\n");
        } else
            res.sendRedirect("./");
    }
}
