package zeta.android.utils.lang.response;

public class TryParseResponse<T> {

    private T mValue;
    private boolean mSuccess;

    public TryParseResponse(T value, boolean isSucess) {
        mValue = value;
        mSuccess = isSucess;
    }

    public T getValue() {
        return mValue;
    }

    public boolean isSuccess() {
        return mSuccess;
    }
}
