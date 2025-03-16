class Solution {
public:
    string reorganizeString(string s) {
        vector<int> hash(26, 0);

        //getting the frequency of each char
        for(int i=0; i<s.length(); i++){
            hash[s[i] - 'a']++;
        }

        //find the max frequent char
        int max_freq = INT_MIN;
        char max_freq_char;

        for(int i=0; i<26; i++){
            if(hash[i] > max_freq){
                max_freq = hash[i];
                max_freq_char = i + 'a';
            }
        }

        int index = 0;
        while(max_freq > 0 && index < s.length()){
            s[index] = max_freq_char;
            max_freq--;
            index += 2;
        }
        //check if we can place the max freq char non adjacently
        if(max_freq != 0) return ""; //cannot place

        //if max freq char placed then make it 0
        hash[max_freq_char - 'a'] = 0;

        //place remaining char's
        for(int i=0; i<26; i++){
            while(hash[i] > 0){
                index = index >= s.length() ? 1 : index;
                s[index] = i + 'a';
                index += 2;
                hash[i]--;
            }
        }

        return s;
    }
};