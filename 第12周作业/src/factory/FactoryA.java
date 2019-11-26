package factory;
import other.*;
import user.UserA;
import user.User;
public class FactoryA implements Factory{
public User produceRecord() {
	return new UserA();
}
}
