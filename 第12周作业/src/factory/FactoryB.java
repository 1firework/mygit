package factory;
import other.*;
import user.UserA;
import user.User;
import user.UserB;
public class FactoryB implements Factory{
public User produceRecord() {
	return new UserB();
}
}
