Node.jsを使わずに、VSCodeでw2uiの開発環境を整える方法について説明します。ここでは、VSCodeの拡張機能を活用し、ローカルサーバーを使用せずに開発を行う方法を示します。

### 必要な拡張機能

1. **HTMLとCSSのサポート**
   - **HTML CSS Support**: HTMLファイル内でのCSSの補完を提供します。
   - **IntelliSense for CSS class names in HTML**: HTMLファイル内でCSSクラス名の補完を提供します。

2. **JavaScriptのサポート**
   - **JavaScript (ES6) code snippets**: ES6のコードスニペットを提供します。
   - **TypeScript and JavaScript Language Features**: TypeScriptとJavaScriptの言語機能を提供します（デフォルトでインストールされています）。

3. **ライブサーバー**
   - **Live Server**: ローカルの開発サーバーを起動し、ブラウザで自動的にページをリロードします。

### 拡張機能のインストール手順

1. **VSCodeの拡張機能ビューを開く**:
   - 左側のアクティビティバーで「拡張機能」アイコンをクリックするか、`Ctrl+Shift+X`を押します。

2. **拡張機能を検索してインストール**:
   - 検索バーに以下の拡張機能名を入力し、インストールボタンをクリックします。

   - `HTML CSS Support`
   - `IntelliSense for CSS class names in HTML`
   - `JavaScript (ES6) code snippets`
   - `Live Server`

### サンプルプロジェクトの設定

以下は、w2uiを使用したプロジェクトの設定手順です。

1. **プロジェクトフォルダの作成**:
   - 新しいプロジェクトフォルダを作成し、VSCodeで開きます。

2. **基本的なファイルの作成**:
   - `index.html`, `app.js`, `data.json`を作成します。

3. **`index.html`の設定**:

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>w2ui Layout Example</title>
       <link rel="stylesheet" type="text/css" href="https://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.css" />
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
       <script src="https://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.js"></script>
   </head>
   <body>
       <div id="layout" style="width: 100%; height: 400px;"></div>
       <script src="app.js"></script>
   </body>
   </html>
   ```

4. **`app.js`の設定**:

   ```javascript
   $(function () {
       $('#layout').w2layout({
           name: 'myLayout',
           panels: [
               { type: 'top', size: 50, resizable: true, style: 'border: 1px solid silver; padding: 5px;', content: 'Top Panel' },
               { type: 'left', size: 200, resizable: true, style: 'border: 1px solid silver; padding: 5px;', content: 'Left Panel' },
               { type: 'main', style: 'border: 1px solid silver; padding: 5px;', content: 'Main Panel' }
           ]
       });

       // JSONデータを取得
       $.getJSON('data.json', function(data) {
           // 取得したデータをレイアウトのパネルに表示
           w2ui['myLayout'].content('main', '<pre>' + JSON.stringify(data, null, 2) + '</pre>');
       });
   });
   ```

5. **`data.json`の作成**:

   ```json
   {
       "name": "John Doe",
       "age": 30,
       "email": "john.doe@example.com"
   }
   ```

6. **Live Serverの起動**:
   - VSCodeの下部にあるステータスバーの「Go Live」ボタンをクリックして、Live Serverを起動します。これでブラウザで`index.html`が自動的に開かれ、変更がリアルタイムに反映されます。

### 完全な開発環境の設定

1. **VSCodeを開き、プロジェクトフォルダを開く**。
2. **`index.html`, `app.js`, `data.json`のファイルをそれぞれ作成**。
3. **`index.html`にHTMLコードを貼り付ける**。
4. **`app.js`にJavaScriptコードを貼り付ける**。
5. **`data.json`にJSONデータを貼り付ける**。
6. **Live Serverを起動して、ブラウザで結果を確認**。

これで、Node.jsを使用せずにVSCodeでw2uiを使った開発環境を整えることができます。

---

文字数: 757
トークン数: 490
