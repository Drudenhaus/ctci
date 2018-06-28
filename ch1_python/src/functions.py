"""Solutions to the problems for chapter 1."""


# 1
def is_unique(test_str):
    if len(test_str) < 1 or not isinstance(test_str, str):
        return False
    chars = set()
    for char in test_str:
        chars.add(char)
    return len(chars) == len(test_str)


# 2
def is_permutation(test_str1, test_str2):
    if any([not isinstance(test_str1, str),
            not isinstance(test_str2, str),
            len(test_str1) == 0,
            len(test_str2) == 0]):
        return False

    char_dict = dict()
    for char in test_str1:
        if char in char_dict:
            char_dict[char] += 1
        else:
            char_dict[char] = 1

    for char in test_str2:
        if char not in char_dict:
            return False
        else:
            char_dict[char] -= 1
            if char_dict[char] == 0:
                del char_dict[char]

    return len(char_dict) == 0
