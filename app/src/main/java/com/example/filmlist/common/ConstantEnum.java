package com.example.filmlist.common;

/**
 * Списко констант, которые используются в приложении
 */
public enum ConstantEnum {
    PRESENTER("presenter"),
    BASE_URL("https://s3-eu-west-1.amazonaws.com/sequeniatesttask/");
    private String code;

    ConstantEnum(String code) {
        this.code = code;
    }

    /**
     * Получение enum по соответствующему коду
     *
     * @param code код
     * @return enum
     */
    public static ConstantEnum of(String code) {
        for (ConstantEnum constant : values()) {
            if (constant.code.equalsIgnoreCase(code)) {
                return constant;
            }
        }
        throw new IllegalArgumentException("такого эффекта нет");
    }

    public String getCode() {
        return code;
    }
}
