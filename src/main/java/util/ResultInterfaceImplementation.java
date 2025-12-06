package util;

import beans.Result;
import database.ResultInterface;
import javax.enterprise.inject.Default;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Default
@Named("resultDao")
public class ResultInterfaceImplementation implements ResultInterface {
    List<Result> results = new ArrayList<>();

    @Override
    public void save(Result result) {
        results.add(result);
    }

    @Override
    public void clear() {

    }

    @Override
    public List<Result> getAll() {
        return results;
    }
}
