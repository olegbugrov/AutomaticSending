package ru.olegbugrov;


class SubjectLetterGenerator {
    private static final int NUM_LETTERS = 5;
    private String[] subject = new String[NUM_LETTERS];

    SubjectLetterGenerator() {
        for (int i = 0; i < NUM_LETTERS; i++) {
            subject[i] = "Verification of sending letters - " + i;
        }
    }

    public String getSubjectByIdx(int idx) {
        return subject[idx];
    }

    public int getNumLetters() {
        return NUM_LETTERS;
    }

}

