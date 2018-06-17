/* Problem: count frequencies of all elements in an array of numbers
   Solution: use hash tables; T(n) = O(n)
*/

#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int main() {
  pair<int, size_t> x;
  unordered_map<int, size_t> myMap;

  int arr[14] = {0,1,2,3,4,2,3,1,8,11,0,3,-1,-2};

  unordered_map<int, size_t>::iterator it;
  for(int i=0;i<14;i++){
    it = myMap.find(arr[i]);
    if(it == myMap.end()){
      x.first = arr[i];
      x.second = 1;
      myMap.insert(x);
    }
    else{
      (it->second)++;
    }
  }

  for(it=myMap.begin();it!=myMap.end();it++){
    cout<<it->first<<" "<<it->second<<endl;
  }
}
