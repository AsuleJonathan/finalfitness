package com.asule.application.bean;


import com.asule.application.model.Member;
import com.asule.database.Database;

import java.io.Serializable;
import java.util.List;

public class MemberBean implements MemberBeanI, Serializable {
    public String upcomingFixtures() {
        List<Member> members = Database.getDbInstance().getMember();

        StringBuilder tbBuilder = new StringBuilder();

        for (Member member : members)
            tbBuilder.append(member.tableRow());

        return tbBuilder.toString();
    }

    public Member addUpdateMember(Member member) throws Exception {
        return member;
    }

    public void deleteMember(Member member) {
        System.out.println("We hope you'll be back");
    }

    @Override
    public Member addUpdateFixture(Member member) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addUpdateFixture'");
    }

    @Override
    public void deleteFixture(Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFixture'");
    }

    public static String[] memberbean() {
        // Assuming 'database' is an instance of your Database class
        Database database = Database.getDbInstance();
    
        // Assuming Member has methods like getName(), getId(), and getStartingDate()
        List<Member> members = database.getMember();
    
        // Print some debugging information
        System.out.println("Number of members: " + members.size());
    
        // Example: Create a String array to store member details
        String[] memberDetails = new String[members.size()];
    
        // Populate the String array with member details
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
    
            // Print some debugging information
            System.out.println("Member " + (i + 1) + " details: " +
                               "Name: " + member.getmemberName() +
                               ", ID: " + member.getmemberId() +
                               ", Starting Date: " + member.getstartingDate());
    
            memberDetails[i] = "Name: " + member.getmemberName() +
                               ", ID: " + member.getmemberId() +
                               ", Starting Date: " + member.getstartingDate();
        }
    
        return memberDetails;
    }
    
}

