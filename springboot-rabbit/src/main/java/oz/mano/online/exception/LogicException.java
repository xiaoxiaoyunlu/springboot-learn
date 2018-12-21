package oz.mano.online.exception;

/**
 * 系统逻辑异常
 * 
 * @author zj
 *
 */
public class LogicException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	public LogicException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
}
