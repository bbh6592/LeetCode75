class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        merged_string = ""
        i, j = 0, 0
        
        # Add characters alternately from both strings
        while i < len(word1) and j < len(word2):
            merged_string += word1[i]
            merged_string += word2[j]
            i += 1
            j += 1
        
        # Add remaining characters from word1 (if any)
        if i < len(word1):
            merged_string += word1[i:]
        
        # Add remaining characters from word2 (if any)
        if j < len(word2):
            merged_string += word2[j:]
        
        return merged_string
