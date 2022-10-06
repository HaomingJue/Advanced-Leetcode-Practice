package practice;

public class LeetCode468_Valid_IP_Address {
    public String validIPAddress(String queryIP) {
        for (int i = 0; i < queryIP.length(); i++) {
            if (queryIP.charAt(i) == '.') {
                return isValidIpv4(queryIP);
            }
            if (queryIP.charAt(i) == ':') {
                return isValidIpv6(queryIP);
            }
        }
        return "Neither";
    }

    private String isValidIpv4(String s) {
        if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') {
            return "Neither";
        }
        String[] xArr = s.split("[.]");
        if (xArr.length != 4) {
            return "Neither";
        }
        for (String x : xArr) {
            if (x.length() > 3 || x.length() == 0) {
                return "Neither";
            }
            if (x.length() == 1 && x.charAt(0) == '0') {
                continue;
            }
            int number = 0;
            for (char c : x.toCharArray()) {
                if (number == 0 && c == '0') {
                    return "Neither";
                }
                if (!(c >= '0' && c <= '9')) {
                    return "Neither";
                }
                number = number * 10 + c - '0';
            }
            if (number > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String isValidIpv6(String s) {
        if (s.charAt(0) == ':' || s.charAt(s.length() - 1) == ':') {
            return "Neither";
        }
        String[] xArr = s.split(":");
        if (xArr.length != 8) {
            return "Neither";
        }
        for (String x : xArr) {
            if (x.length() > 4 || x.length() == 0) {
                return "Neither";
            }
            for (char c : x.toCharArray()) {
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <='f') || (c >='A' && c <='F'))) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
