package util;

public interface Observer<Subject, Data> {

    void update(Subject subject, Data data);

}
