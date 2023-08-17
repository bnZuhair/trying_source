#include <iostream>
#include <algorithm>
using namespace std;

const int MAX_CAPACITY = 100;

struct book
{
    int id, quantity;
    string name;
    bool is_borrowed;

    book(int new_id = -1, string new_name = "", int new_quantity = 10)
    {
        id = new_id;
        name = new_name;
        quantity = new_quantity;
        is_borrowed = false;
    }
    void read_book()
    {
        cout << "Enter Id, name and quantity for the book\n";
        cin >> id >> name >> quantity;
        is_borrowed = false;
    }

    void print_book()
    {
        cout << id << " " << name << " " << quantity << "\n";
    }
};

bool compare_book_by_name(book &a, book &b) { return a.name < b.name; }
bool compare_book_by_id(book &a, book &b) { return a.id < b.id; }

struct user
{
    int id;
    string name;
    int has_borrowed;

    user(int new_id = -1, string new_name = "")
    {
        id = new_id;
        name = new_name;
        has_borrowed = -1;
    }
    void read_user()
    {
        cout << "Enter Id and name for the user\n";
        cin >> id >> name;
    }

    void print_user()
    {
        cout << id << " " << name << "\n";
    }
};

struct library_system
{
    int total_books{0};
    book books[MAX_CAPACITY];
    int total_users{0};
    user users[MAX_CAPACITY];

    void print_menu()
    {
        cout << "Library Menu: \n"
             << "1) add book\n"
             << "2) search books by prefix\n"
             << "3) print who borrowed book by name\n"
             << "4) print library by id\n"
             << "5) print library by name\n"
             << "6) add user\n"
             << "7) user borrow book\n"
             << "8) user return book\n"
             << "9) print users\n"
             << "10) Exit\n";
    }
    int read_choice()
    {
        cout << "Enter your menu choice [1 - 10]: ";
        int choice;
        cin >> choice;
        return choice;
    }
    void add_book()
    {
        books[total_books++].read_book();
    }

    bool compare_name_by_prefix(const string& name, const string& prefix)
    {
        bool is_matching = true;
        for (int i = 0; i < prefix.size(); i++)
        {
            if (name[i] != prefix[i])
            {
                is_matching = false;
                break;
            }
        }
        return is_matching;
    }

    void search_books_by_prefix()
    {
        string user_prefix;
        cout << "Enter the prefix of the book: ";
        cin >> user_prefix;
        for (int i = 0; i < total_books; i++)
        {
            bool is_matching_by_prefix = compare_name_by_prefix(books[i].name, user_prefix);
            if (is_matching_by_prefix)
                cout << books[i].name << endl;
        }
    }

    void print_who_borrowed_book_by_name()
    {

    }

    void print_library_by_id()
    {
        sort(books, books + total_books, compare_book_by_id);

        cout << "id book name quantaty\n";
        for (int i = 0; i < total_books; ++i)
            books[i].print_book();
        cout << "\n\n"
    }
    void print_library_by_name()
    {
        sort(books, books + total_books, compare_book_by_name);

        cout << "id book name quantaty\n";
        for (int i = 0; i < total_books; i++)
            books[i].print_book();
        cout << "\n\n"
    }


    void add_user()
    {
        users[total_users++].read_user();
    }

    void user_borrow_book()
    {

    }

    void user_return_book()
    {

    }

    void print_users()
    {
        cout << "Id    Name";
        for (int i = 0; i < total_users; i++)
            users[i].print_user();
        }

    void run_system()
    {
        while (true)
        {
            print_menu();
            int user_choice = read_choice();

            if (user_choice == 1)
                add_book();
            else if (user_choice == 2)
                search_books_by_prefix();
            else if (user_choice == 3)
                print_who_borrowed_book_by_name();
            else if (user_choice == 4)
                print_library_by_id();
            else if (user_choice == 5)
                print_library_by_name();
            else if (user_choice == 6)
                add_user();
            else if (user_choice == 7)
                user_borrow_book();
            else if (user_choice == 8)
                user_return_book();
            else if (user_choice == 9)
                print_users();
            else if (user_choice == 10)
                break;
            else
                cout << "please enter a valid choice [1 - 10]\n\n";
        }
    }
};

int main()
{
    library_system library_1;
    library_1.run_system();

    return 0;
}