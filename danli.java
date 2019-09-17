class Hero{
private Hero(){
}
private static Hero instance = new Hero()
public static Hero getInstance(){
return instance;
}
}