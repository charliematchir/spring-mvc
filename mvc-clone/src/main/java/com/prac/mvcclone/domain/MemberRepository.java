package com.prac.mvcclone.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepository {
    private static Map<Long, Member> storage = new ConcurrentHashMap<>();
    private static long seq = 0L;
    // 싱글톤 레포지토리
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member) {
        member.setId(++seq);
        storage.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return storage.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void clearStore() {
        storage.clear();
    }


}
