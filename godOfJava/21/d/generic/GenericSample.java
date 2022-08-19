package d.generic;

public class GenericSample {
    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
        sample.checkCastingDTO();
        sample.checkGenericDTO();
    }

    public void checkCastingDTO() {
        /*
           CastingDTO 를 Generic 으로 선언하지 않았을경우 선언방식
         */
        CastingDTO dto1 = new CastingDTO();
        dto1.setObject(new String());

        CastingDTO dto2 = new CastingDTO();
        dto2.setObject(new StringBuffer());

        CastingDTO dto3 = new CastingDTO();
        dto3.setObject(new StringBuilder());
    }

    public void checkGenericDTO() {
        /*
            CastingDTO 를 Generic으로 선언했을경우 선언방식
         */
        CastingDTO<String> dto1 = new CastingDTO<>();
        dto1.setObject(new String());

        CastingDTO<StringBuffer> dto2 = new CastingDTO<>();
        dto2.setObject(new StringBuffer());

        CastingDTO<StringBuilder> dto3 = new CastingDTO<>();
        dto3.setObject(new StringBuilder());
    }
}