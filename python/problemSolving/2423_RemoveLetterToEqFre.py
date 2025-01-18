class Solution:
    def equalFrequency(self, word: str) -> bool:
        fre = [0 for i in range(26)]
        for l in word:
            fre[ord(l) - ord("a")] += 1
        fre.sort()
        fre = [i for i in fre if i != 0]
        for i in range(len(fre) - 1, -1, -1):
            if fre[i] == len(word):
                return True
            elif (fre[i] == fre[i - 1]) and fre[i] == 1:
                return True
            elif (fre[i] - fre[i - 1]) == 1 and fre[i - 1] == fre[0]:
                return True
            elif fre[i] == fre[1] and fre[0] == 1:
                return True
            else:
                return False
