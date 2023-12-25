package user;

import user.dao.ConnectionMaker;
import user.dao.DConnectionMaker;
import user.dao.DaoFactory;
import user.dao.UserDao;
import user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        UserDao dao = new UserDao(connectionMaker);
//        두 오브젝트 사이의 의존관계 설정
//        UserDao에서 DConnectionMaker를 직접 참조(UserDao.connectionMaker = new DConnectionMaker();)하지 않고
//        main이 그 책임을 떠안음(main이 ConnectionMaker를 생성, UserDao에게 해당 ConnectionMaker를 삽입해 의존관계 생성해줌)
//        UserDao dao = new UserDao(new DConnectionMaker());

//        메인이 얼떨결에 떠맡았던 두 오브젝트의 결합 역할을 Factory가 대신 하게 만들고 메인에서는 본래의 책임인 테스트만 진행함
        UserDao dao = new DaoFactory().userDao();


        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");

    }
}
