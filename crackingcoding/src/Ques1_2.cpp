#include<iostream>

using namespace std;

void reverse(char* str){
	char* end;
	char* start;
	char tmp;
	end = str;

	while(*end){
		end++;
	}
	end--;

	while( start < end){
		tmp = *start;
		*start++ = *end;
		*end-- = tmp;
	}
}

int main(){
	char* str;
	//char* rvStr;
	cout<<"Enter String you want to Reverse"
	cin>>str;

	reverse(str);
	cout<<str;
	return 0;
}
