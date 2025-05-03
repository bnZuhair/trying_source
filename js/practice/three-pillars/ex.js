class Bookshelf {
   constructor() {
      this.favoriteBooks = [];
   }

   printFavorteBooks() {
      console.log(`Favorite Books: ${this.favoriteBooks.length}`);
      for (const book of this.favoriteBooks) {
         console.log(book);
      }
   }
   addFavoriteBook(bookName) {
      if (!bookName.includes("Great")) {
         this.favoriteBooks.push(bookName);
      }
   }
}

async function loadBooks(shelf) {
   fakeAjax(BOOK_API, function addBooksToShelf(books) {
      for (const book of books) {
         shelf.addFavoriteBook(book);
      }
      shelf.printFavorteBooks();
   });
}

BOOK_API = "https://some.url/api";
myShelf = new Bookshelf();
loadBooks(myShelf);

// ***********************

// NOTE: don't modify this function at all
function fakeAjax(url, cb) {
   setTimeout(function fakeLoadingDelay() {
      cb([
         "A Song of Ice and Fire",
         "The Great Gatsby",
         "Crime & Punishment",
         "Great Expectations",
         "You Don't Know JS",
      ]);
   }, 500);
}
