package com.greatersum.rental;

import java.math.BigDecimal;

public enum MovieCategory {

    REGULAR {
        @Override
        int bonusPoints(int days) {
            return 1;
        }

        @Override
        BigDecimal rentalPrice(int days) {
            BigDecimal price = BigDecimal.valueOf(2);
            if (days > 2) {
                price = BigDecimal.valueOf((days - 2) * 1.5).add(price);
            }
            return price;
        }
    },
    NEW {
        @Override
        int bonusPoints(int days) {
            // add bonus for a two day new release rental
            return days > 2 ? 2 : 1;
        }

        @Override
        BigDecimal rentalPrice(int days) {
            return BigDecimal.valueOf(days * 3);
        }
    },
    CHILDRENS {
        @Override
        int bonusPoints(int days) {
            return 1;
        }

        @Override
        BigDecimal rentalPrice(int days) {
            BigDecimal price = BigDecimal.valueOf(1.5);
            if (days > 3) {
                price = BigDecimal.valueOf((days - 3) * 1.5).add(price);
            }
            return price;
        }
    };

    abstract int bonusPoints(int days);

    abstract BigDecimal rentalPrice(int days);
}