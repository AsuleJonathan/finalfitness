package com.asule.application.bean;


import com.asule.application.model.Member;

public interface MemberBeanI {
    public  String upcomingFixtures();
    public Member addUpdateFixture(Member member) throws  Exception;
    public  void deleteFixture(Member member);
}

