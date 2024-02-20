package com.asule.application.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class Member implements Serializable {

    private String memberName;
    private String memberId;
    private String startingDate;
    
        // Constructor with three arguments
        public Member(String memberName, String memberId, String startingDate) {
            this.memberName = memberName;
            this.memberId = memberId;
            this.startingDate = startingDate;
        }
    

    public String getmemberName() {
        return memberName;
    }

    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getmemberId() {
        return memberId;
    }

    public void setmemberID(String memberId) {
        this.memberId = memberId;
    }
        public String getstartingDate() {
        return startingDate;
    }

    public void setstartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String tableRow() {
        StringBuilder tbBuilder = new StringBuilder();
        tbBuilder.append("<div class=\"Member details\">");
        tbBuilder.append("  <div class=\"member ID\">");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getmemberId())).append("</p>");
        tbBuilder.append(" </div>");
        tbBuilder.append("<div class=\"name\">");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getmemberName())).append("</p>");
        tbBuilder.append(" </div>");
        tbBuilder.append("<div class=\"date\">");
        tbBuilder.append("<td>").append(StringUtils.trimToEmpty(getstartingDate())).append("</td>");
        tbBuilder.append(" </div>");
        tbBuilder.append("</div>");
        return tbBuilder.toString();

    }

}
