## Welcome to easyTools

EasyTools is a simple project to add simple looking - pieces of code, code which is more or less a utility and is missing from lot of other utility Projects (Such as Apache commons)

### Sample tools: EnumUtil

Enum util is a util class which will allow one to extract the enum instance out of the corresponding string (name() or toString()).

Ex:
```markdown

import com.hs.easyTools.datatype.EnumUtil;

public class Test {

  enum TrueOrFalse {
    TRUE("true"), FALSE("false");
    
    private final String t;
    
    TrueOrFalse(String t) {
      this.t = t;
    }
    
    @Override
    public String toString() {
      return t;
    }
  }
  
  public static void main(String args[]) {
    TrueOrFalse TRUE = EnumUtil.getValue(TrueOrFalse.class, "true");
    TrueOrFalse FALSE = new EnumUtil<>(TrueOrFalse.class).getValue("FALSE");
  }
}
```

### Support or Contact
Please contribute to this project by pushing more such utilitites :)
