package epacman.common;

/**
 *
 * @author ErickSteven
 */
public interface BoardMatrix {

    int[] CLASSIC_BOARD_SPRITES = {
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4,
        5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5,
        5, 6, 9, 10, 10, 11, 6, 9, 10, 10, 10, 11, 6, 7, 7, 6, 9, 10, 10, 10, 11, 6, 9, 10, 10, 11, 6, 5,
        5, 6, 7, 6, 6, 7, 6, 7, 6, 6, 6, 7, 6, 7, 7, 6, 7, 6, 6, 6, 7, 6, 7, 6, 6, 7, 6, 5,
        5, 6, 12, 10, 10, 13, 6, 12, 10, 10, 10, 13, 6, 12, 13, 6, 12, 10, 10, 10, 13, 6, 12, 10, 10, 13, 6, 5,
        5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5,
        5, 6, 9, 10, 10, 11, 6, 9, 11, 6, 9, 10, 10, 10, 10, 10, 10, 11, 6, 9, 11, 6, 9, 10, 10, 11, 6, 5,
        5, 6, 12, 10, 10, 13, 6, 7, 7, 6, 12, 10, 10, 11, 9, 10, 10, 13, 6, 7, 7, 6, 12, 10, 10, 13, 6, 5,
        5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 5,
        16, 1, 1, 1, 1, 4, 6, 7, 12, 10, 10, 11, 6, 7, 7, 6, 9, 10, 10, 13, 7, 6, 0, 1, 1, 1, 1, 14,
        6, 6, 6, 6, 6, 5, 6, 7, 9, 10, 10, 13, 6, 12, 13, 6, 12, 10, 10, 11, 7, 6, 5, 6, 6, 6, 6, 6,
        6, 6, 6, 6, 6, 5, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 5, 6, 6, 6, 6, 6,
        6, 6, 6, 6, 6, 5, 6, 7, 7, 6, 0, 1, 19, 6, 6, 20, 1, 4, 6, 7, 7, 6, 5, 6, 6, 6, 6, 6,
        1, 1, 1, 1, 1, 14, 6, 12, 13, 6, 5, 6, 6, 6, 6, 6, 6, 5, 6, 12, 13, 6, 16, 1, 1, 1, 1, 1,
        6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 6, 6, 6, 6, 6, 6, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
        1, 1, 1, 1, 1, 4, 6, 9, 11, 6, 5, 6, 6, 6, 6, 6, 6, 5, 6, 9, 11, 6, 0, 1, 1, 1, 1, 1,
        6, 6, 6, 6, 6, 5, 6, 7, 7, 6, 16, 1, 1, 1, 1, 1, 1, 14, 6, 7, 7, 6, 5, 6, 6, 6, 6, 6,
        6, 6, 6, 6, 6, 5, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 5, 6, 6, 6, 6, 6,
        6, 6, 6, 6, 6, 5, 6, 7, 7, 6, 9, 10, 10, 10, 10, 10, 10, 11, 6, 7, 7, 6, 5, 6, 6, 6, 6, 6,
        0, 1, 1, 1, 1, 14, 6, 12, 13, 6, 12, 10, 10, 11, 9, 10, 10, 13, 6, 12, 13, 6, 16, 1, 1, 1, 1, 4,
        5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5,
        5, 6, 9, 10, 10, 11, 6, 9, 10, 10, 10, 11, 6, 7, 7, 6, 9, 10, 10, 10, 11, 6, 9, 10, 10, 11, 6, 5,
        5, 6, 12, 10, 11, 7, 6, 12, 10, 10, 10, 13, 6, 12, 13, 6, 12, 10, 10, 10, 13, 6, 7, 9, 10, 13, 6, 5,
        5, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 5,
        8, 10, 11, 6, 7, 7, 6, 9, 11, 6, 9, 10, 10, 10, 10, 10, 10, 11, 6, 9, 11, 6, 7, 7, 6, 9, 10, 15,
        17, 10, 13, 6, 12, 13, 6, 7, 7, 6, 12, 10, 10, 11, 9, 10, 10, 13, 6, 7, 7, 6, 12, 13, 6, 12, 10, 18,
        5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 5,
        5, 6, 9, 10, 10, 10, 10, 13, 12, 10, 10, 11, 6, 7, 7, 6, 9, 10, 10, 13, 12, 10, 10, 10, 10, 11, 6, 5,
        5, 6, 12, 10, 10, 10, 10, 10, 10, 10, 10, 13, 6, 12, 13, 6, 12, 10, 10, 10, 10, 10, 10, 10, 10, 13, 6, 5,
        5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5,
        16, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 14};
    int[] CLASSIC_BOARD_FOOD = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, //28
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
        0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
        0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
        0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
        0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0,
        0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0,
        0, 2, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 2, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, //280
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 4, 4, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, //560
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
        0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
        0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, //644
        0, 2, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 0,
        0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0,
        0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0,
        0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0,
        0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
        0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
}
