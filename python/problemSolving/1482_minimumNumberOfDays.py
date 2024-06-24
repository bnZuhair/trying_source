        """
        :type bloomDay: List[int]
        :type m: int
        :type k: int
        :rtype: int
        """
class Solution(object):
    def minDays(self, bloomDay, m, k):
        totalflowersneeded = m * k
        if( totalflowersneeded < bloomDay):
            return -1
        else:
          


