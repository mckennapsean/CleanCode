package clean.code.chapter14.refactored.step.by.step;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
  private boolean booleanValue = false;

  @Override
  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      booleanValue = new Boolean(currentArgument.next());
    } catch (NoSuchElementException e) {
      throw new ArgsException(ArgsException.ErrorCode.MISSING_BOOLEAN);
    }
  }

  public static boolean getValue(ArgumentMarshaler am) {
    if ((am != null) && am instanceof BooleanArgumentMarshaler) {
      return ((BooleanArgumentMarshaler) am).booleanValue;
    } else {
      return false;
    }
  }
}