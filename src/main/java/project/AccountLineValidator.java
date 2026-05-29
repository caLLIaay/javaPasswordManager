    package project;

    public class AccountLineValidator {
        private String line;

        AccountLineValidator() {
            this.line = null;
        }
        AccountLineValidator(String line) {
            this.line = line;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }


        public boolean checkPasswordForLength(String ThirdParameterOfTheStringArray) {
            return ThirdParameterOfTheStringArray.length() >= 8;
        }


        // Проверяем на то, что у нас именно три части
        public boolean checkIfLineHasThreeParts(String lineFromFile) {
            if (lineFromFile.isEmpty()) {
                return false;
            }
            String[] splitString = lineFromFile.split(";", -1);
            return splitString.length == 3;
        }

        public boolean checkFieldsForFullness(String lineFromFile) {
            if (!checkIfLineHasThreeParts(lineFromFile)) {
                return false;
            }

            String[] splitLines = lineFromFile.split(";", -1);

            if(splitLines[0].isBlank() || splitLines[1].isBlank() || (splitLines[2].isBlank())) {
                return false;
            }
            return splitLines[2].length() >= 8;
        }





        public boolean lineValidator(String lineFromFile) {
            return !lineFromFile.isEmpty() &&
                    checkIfLineHasThreeParts(lineFromFile) &&
                    checkFieldsForFullness(lineFromFile);
        }

    }
