package user.dao;

public class DaoFactory {
    public UserDao userDao(){
//        팩토리(Factory)
//        객체의 생성 방법을 결정하고 그렇게 만들어진 오브젝트를 돌려주는 클래스(오브젝트)
//        ⚠️ 디자인 패턴에서의 추상 팩토리 패턴이나 메소드 패턴과는 다른 의미임
//        UserDao userDao = new UserDao(new DConnectionMaker());
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;

//        return new UserDao(new DConnectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

//    중복 코드 메서드로 분리
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

}
