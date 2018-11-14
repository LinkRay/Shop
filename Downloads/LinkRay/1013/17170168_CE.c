#include <iostream>
#include <cstring>
using namespace std;
char Left[3][7];
char Right[3][7];
char result[3][7];
bool Fake(char c,bool light)
{
    for(int i=0;i<3;i++)
    {
        char *pleft,*pright;
        if(light)
        {
            pleft=Left[i];
            pright=Right[i];
        }
        if(!light)
        {
            pleft=Right[i];
            pright=Left[i];
        }
        switch(result[i][0])
        {
            case 'u':
                if(strchr(pleft,c))
                    return false;
                break;
            case 'e':
                if(strchr(pleft,c)||strchr(pright,c))
                    return false;
                break;
            case 'd':
                if(strchr(pright,c))
                    return false;
                break;
        }
    }
    return true;
}
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        for(int i=0;i<3;i++)
            cin>>Left[i]>>Right[i]>>result[i];
        for(char c='A';c<='L';c++)
        {
            if(Fake(c,true))
            {
                cout<<c<<" is the counterfeit coin and it is light."<<endl;
                break;
            }
            if(Fake(c,false))
            {
                cout<<c<<" is the counterfeit coin and it is heavy."<<endl;
                break;
            }
        }
    }
    return 0;
}