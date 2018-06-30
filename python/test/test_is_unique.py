import unittest

from python.src.functions import is_unique
from python.src.functions import is_permutation


#1
class TestIsUnique(unittest.TestCase):
    def test_is_unique_true(self):
        test_str = "abcd"
        self.assertTrue(is_unique(test_str))

    def test_is_unique_false(self):
        test_str = "aaaa"
        self.assertFalse(is_unique(test_str))

    def test_is_unique_empty(self):
        test_str = ""
        self.assertFalse(is_unique(test_str))

    def test_is_unique_wrong_type(self):
        test_str = ["abcd"]
        self.assertFalse(is_unique(test_str))


#2
class TestIsPermutation(unittest.TestCase):
    def test_is_permutation_true(self):
        test_str1 = "abcd"
        test_str2 = "dacb"
        self.assertTrue(is_permutation(test_str1, test_str2))

    def test_is_permutation_false(self):
        test_str1 = "abcd"
        test_str2 = "abc1"
        self.assertFalse(is_permutation(test_str1, test_str2))

    def test_is_permutation_empty(self):
        test_str1 = ""
        test_str2 = "abc1"
        self.assertFalse(is_permutation(test_str1, test_str2))

    def test_is_permutation_wrong_type(self):
        test_str1 = ["abcd"]
        test_str2 = "abcd"
        self.assertFalse(is_permutation(test_str1, test_str2))
