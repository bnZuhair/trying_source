import bisect
class Solution(object):
    def minDays(self, bloomDay, m, k):
        minFlowerNeeded = m * k
        if( len(bloomDay) < minFlowerNeeded ):
            return -1
        else:
            if( k == 1):
                bloomDay = sorted(bloomDay)
                return bloomDay[m - 1]
            else:
                remaningFlowers = len(bloomDay) - minFlowerNeeded  

                listOfBouquets = []
                usedIndices = []
                adjFlowers = 0
                maxDay = 0
                
                for i in range(0, remaningFlowers):
                    lastIndex = len(bloomDay) - 1
                    maxDay = max(bloomDay[lastIndex:lastIndex - k:-1])
                    maxDayIndex = bloomDay.index(maxDay)
                    if( maxDayIndex not in usedIndices):
                        usedIndices.append( maxDayIndex )
                        bisect.insort(listOfBouquets, maxDay)
                    
                for i in range(minFlowerNeeded, -1, -1):
                    adjFlowers += 1
                    if(maxDay < bloomDay[i]):
                        maxDay = bloomDay[i]
                    if(adjFlowers == k ):
                        bisect.insort(listOfBouquets, maxDay)
                        maxDay = 0
                        adjFlowers = 0
                if(len(listOfBouquets) < m):
                    return -1
                return listOfBouquets[m - 1]
