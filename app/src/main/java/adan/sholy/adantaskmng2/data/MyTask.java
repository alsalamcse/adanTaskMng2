package adan.sholy.adantaskmng2.data;

public class MyTask
{
     private String key;
     private String title;
     private String subject;
     private String owner;
     private int important;

     public MyTask(){

     }
     public String getOwner(){
         this.owner=owner;
         return null;
     }
     public void setOwner(String owner){
         this.owner=owner;
     }
     public String getkey(){
         return key;

     }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }
    @Override
    public String toString()
    {
        return "My Task(" +
                "key='" + key +'\'' +
                ",title'" + title +'\'' +
                ",subject='"+subject+'\''+
                ",important=" +important +
                '}';
    }

}
