package inflearn.inflearnspringboot.chapter2.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
