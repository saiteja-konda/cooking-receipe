(this["webpackJsonpblog-fronend"]=this["webpackJsonpblog-fronend"]||[]).push([[0],{110:function(e,t,a){"use strict";a.r(t),a.d(t,"default",(function(){return o}));var n=a(0),r=a.n(n);function o(){return r.a.createElement("div",null)}},111:function(e,t,a){"use strict";a.r(t),a.d(t,"default",(function(){return c}));var n=a(0),r=a.n(n),o=a(59);function c(){return r.a.createElement("section",{className:"container"},r.a.createElement("div",{className:"row"},r.a.createElement("h2",{className:"mt-5"},"Trending Posts"),r.a.createElement(o.a,null)))}},112:function(e,t,a){"use strict";a.r(t),a.d(t,"default",(function(){return o}));var n=a(0),r=a.n(n);function o(){return r.a.createElement("div",null)}},113:function(e,t,a){"use strict";a.r(t),a.d(t,"default",(function(){return o}));var n=a(0),r=a.n(n);function o(){return r.a.createElement("section",{className:"container home"},r.a.createElement("div",{className:"row"},r.a.createElement("h2",{className:"mt-5"},"Trending Posts")))}},133:function(e,t,a){e.exports=a(260)},255:function(e,t,a){var n={"./about":110,"./about.jsx":110,"./blog":111,"./blog.jsx":111,"./contact":112,"./contact.jsx":112,"./home":113,"./home.jsx":113};function r(e){var t=o(e);return a(t)}function o(e){if(!a.o(n,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return n[e]}r.keys=function(){return Object.keys(n)},r.resolve=o,e.exports=r,r.id=255},257:function(e,t,a){},260:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),o=a(7),c=a.n(o),l=a(35),i=a(9),s=a(59),m=a(23),u=a(40),d=a(41),p=a(47),h=a(46),f=a(127),E=a(306),b=a(308),g=a(34),v=a.n(g),j=function(e){Object(p.a)(a,e);var t=Object(h.a)(a);function a(){var e;Object(u.a)(this,a);for(var n=arguments.length,r=new Array(n),o=0;o<n;o++)r[o]=arguments[o];return(e=t.call.apply(t,[this].concat(r))).state={description:"",title:"",content:"",categoryId:"",fetchedData:[]},e.onchangeHandler=function(t){t.preventDefault(),e.setState(Object(m.a)({},t.target.name,t.target.value))},e.onSubmit=function(t){var a;t.preventDefault(),a={title:e.state.title,content:e.state.content,description:e.state.description,categoryId:e.state.categoryId},v()({method:"POST",url:"https://saiteja-blog.herokuapp.com/post",data:a}),window.location.href="/"},e}return Object(d.a)(a,[{key:"componentDidMount",value:function(){var e=this;v()({method:"GET",url:"https://saiteja-blog.herokuapp.com/category",headers:{"Content-Type":"application/json"}}).then((function(t){return e.setState({fetchedData:t.data})})),console.log(this.state.fetchedData)}},{key:"render",value:function(){var e=this.state.fetchedData;return r.a.createElement("div",{className:"container"},r.a.createElement("h1",null,"Add New Post"),r.a.createElement("div",{className:"form-group"},r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("label",{className:"text-dark text-blod"},"Title"),r.a.createElement("input",{className:"form-control",name:"title",onChange:this.onchangeHandler,value:this.state.title,placeholder:"Title"}),r.a.createElement("label",{className:"text-dark text-blod"},"Description"),r.a.createElement("textarea",{className:"form-control",name:"description",onChange:this.onchangeHandler,value:this.state.description,placeholder:"Description"}),r.a.createElement("label",{className:"text-dark text-blod"},"Content"),r.a.createElement(f.a,{className:"form-control",minRows:"18",cols:"70",name:"content",onChange:this.onchangeHandler,value:this.state.content,placeholder:"Content"}),r.a.createElement("label",{className:"text-dark text-blod"},"Category"),r.a.createElement("select",{className:"form-control",name:"categoryId",onChange:this.onchangeHandler,value:this.state.categoryId,placeholder:"Category"},e.map((function(e){return r.a.createElement("option",{key:e.id,value:e.id},e.name)}))),r.a.createElement(E.a,{type:"primary",htmlType:"submit",icon:r.a.createElement(b.a,null)},"Post"))))}}]),a}(n.Component),w=a(68),y=[{title:"Home",path:"/home"},{title:"Blog",path:"/blog"},{title:"Portfolio",path:"/about"},{title:"Contact",path:"/contact"}];function O(){var e=Object(n.useState)(!1),t=Object(w.a)(e,2),a=t[0],o=t[1];return r.a.createElement("nav",{className:"site-navigation"},r.a.createElement("span",{className:"menu-title navbrand"},r.a.createElement("img",{src:"https://raw.githubusercontent.com/saiteja-konda/Saiteja.dev/master/assets/logos/logo.png",alt:"logo",width:"50px",height:"50px"})),r.a.createElement("div",{className:"menu-content-container ".concat(a&&"active"," ")},r.a.createElement("ul",null,y.map((function(e,t){return r.a.createElement("li",{key:t},r.a.createElement(l.b,{to:e.path},e.title))})))),r.a.createElement("i",{className:"ionicons icon ion-ios-menu",onClick:function(){return o(!a)}}))}function N(){return function(e){try{return r.a.createElement(a(255)("./".concat(e)).default)}catch(t){return console.warn(t),r.a.createElement((function(){return 404}))}}(Object(i.g)().params.page)}var k=a(60),x=a.n(k),C=function(e){Object(p.a)(a,e);var t=Object(h.a)(a);function a(){var e;Object(u.a)(this,a);for(var n=arguments.length,r=new Array(n),o=0;o<n;o++)r[o]=arguments[o];return(e=t.call.apply(t,[this].concat(r))).state={fetchedData:""},e}return Object(d.a)(a,[{key:"componentDidMount",value:function(){var e=this;v()({method:"GET",url:"https://saiteja-blog.herokuapp.com/post/".concat(this.props.match.params.id),headers:{"Content-Type":"application/json"}}).then((function(t){return e.setState({fetchedData:t.data})})).then(console.log(this.props.match.params.id))}},{key:"render",value:function(){var e=this.state.fetchedData;return r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"row"},r.a.createElement("div",null,r.a.createElement("h1",{className:"mt-5"},e.title),r.a.createElement(x.a,{source:e.content}))))}}]),a}(n.Component),D=a(119),S=a(3),T=a(295),B=a(44),I=a(307),P=a(299),H=a(300),A=a(303),G=a(297),M=a(72),W=a(302),L=a(301),R=a(121),z=a.n(R),J=a(123),U=a.n(J),_=a(122),F=a.n(_),K=a(309),X=a(304),$=a(305),q=a(124),Q=a.n(q),V=a(125),Y=a.n(V),Z=Object(T.a)((function(e){return{root:{display:"flex"},appBar:{zIndex:e.zIndex.drawer+1,transition:e.transitions.create(["width","margin"],{easing:e.transitions.easing.sharp,duration:e.transitions.duration.leavingScreen})},appBarShift:{marginLeft:240,width:"calc(100% - ".concat(240,"px)"),transition:e.transitions.create(["width","margin"],{easing:e.transitions.easing.sharp,duration:e.transitions.duration.enteringScreen})},menuButton:{marginRight:36},hide:{display:"none"},drawer:{width:240,flexShrink:0,whiteSpace:"nowrap"},drawerOpen:{width:240,transition:e.transitions.create("width",{easing:e.transitions.easing.sharp,duration:e.transitions.duration.enteringScreen})},drawerClose:Object(m.a)({transition:e.transitions.create("width",{easing:e.transitions.easing.sharp,duration:e.transitions.duration.leavingScreen}),overflowX:"hidden",width:e.spacing(7)+1},e.breakpoints.up("sm"),{width:e.spacing(9)+1}),toolbar:Object(D.a)({display:"flex",alignItems:"center",justifyContent:"flex-end",padding:e.spacing(0,1)},e.mixins.toolbar),content:{flexGrow:1,padding:e.spacing(3)}}}));function ee(){var e,t,a=Z(),n=Object(B.a)(),o=r.a.useState(!1),c=Object(w.a)(o,2),l=c[0],i=c[1];return r.a.createElement("div",{className:a.root},r.a.createElement(G.a,null),r.a.createElement(P.a,{position:"fixed",className:Object(S.a)(a.appBar,Object(m.a)({},a.appBarShift,l))},r.a.createElement(H.a,null,r.a.createElement(L.a,{color:"inherit","aria-label":"open drawer",onClick:function(){i(!0)},edge:"start",className:Object(S.a)(a.menuButton,Object(m.a)({},a.hide,l))},r.a.createElement(z.a,null)),r.a.createElement(M.a,{variant:"h6",noWrap:!0},"Welcome Saiteja Konda"))),r.a.createElement(I.a,{variant:"permanent",className:Object(S.a)(a.drawer,(e={},Object(m.a)(e,a.drawerOpen,l),Object(m.a)(e,a.drawerClose,!l),e)),classes:{paper:Object(S.a)((t={},Object(m.a)(t,a.drawerOpen,l),Object(m.a)(t,a.drawerClose,!l),t))}},r.a.createElement("div",{className:a.toolbar},r.a.createElement(L.a,{onClick:function(){i(!1)}},"rtl"===n.direction?r.a.createElement(F.a,null):r.a.createElement(U.a,null))),r.a.createElement(W.a,null),r.a.createElement(A.a,null,["Dasboard","Analytics","Logout","Drafts"].map((function(e,t){return r.a.createElement(K.a,{button:!0,key:e},r.a.createElement(X.a,null,t%2===0?r.a.createElement(Q.a,null):r.a.createElement(Y.a,null)),r.a.createElement($.a,{primary:e}))}))),r.a.createElement(W.a,null)),r.a.createElement("main",{className:a.content},r.a.createElement("div",{className:a.toolbar})))}var te=function(){return r.a.createElement(l.a,null,r.a.createElement("div",null,r.a.createElement(i.b,{exact:!0,path:"/posts",component:s.a}),r.a.createElement(i.b,{exact:!0,path:"/addPost",component:j}),r.a.createElement(O,null),r.a.createElement(i.d,null,r.a.createElement(i.b,{exact:!0,path:"/post/:id",component:C}),r.a.createElement(i.b,{exact:!0,path:"/admin",component:ee}),r.a.createElement(i.b,{path:"/:page",component:N}),r.a.createElement(i.b,{path:"/",render:function(){return r.a.createElement(i.a,{to:"/home"})}}),r.a.createElement(i.b,{component:function(){return 404}}))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));a(256),a(257),a(258),a(259);c.a.render(r.a.createElement(r.a.StrictMode,null,r.a.createElement(te,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))},59:function(e,t,a){"use strict";var n=a(40),r=a(41),o=a(47),c=a(46),l=a(0),i=a.n(l),s=a(34),m=a.n(s),u=a(60),d=a.n(u),p=a(35),h=function(e){Object(o.a)(a,e);var t=Object(c.a)(a);function a(){var e;Object(n.a)(this,a);for(var r=arguments.length,o=new Array(r),c=0;c<r;c++)o[c]=arguments[c];return(e=t.call.apply(t,[this].concat(o))).state={fetchedData:[]},e.handleClick=function(e){e.preventDefault();var t=[e.currentTarget.value];m()({method:"GET",url:"https://saiteja-blog.herokuapp.com/post/".concat(t),headers:{"Content-Type":"application/json"}}).then((function(e){return console.log(e)}))},e}return Object(r.a)(a,[{key:"componentDidMount",value:function(){var e=this;m()({method:"GET",url:"https://saiteja-blog.herokuapp.com/post/",headers:{"Content-Type":"application/json"}}).then((function(t){return e.setState({fetchedData:t.data})}))}},{key:"render",value:function(){var e=this.state.fetchedData;return i.a.createElement("div",{className:"container posts body"},e.map((function(e){return i.a.createElement("div",{className:"box",key:e.id},i.a.createElement("div",{className:"content"},i.a.createElement("img",{src:"{https://picsum.photos/800/900}",alt:""}),i.a.createElement("h3",null,e.title),i.a.createElement("pre",null,e.genre),i.a.createElement(d.a,{source:e.description}),i.a.createElement(p.b,{to:"/post/".concat(e.id)},i.a.createElement("button",{className:"btn btn-sm btn-dark",value:e.id},"Read more"))))})))}}]),a}(l.Component);t.a=h}},[[133,1,2]]]);
//# sourceMappingURL=main.5b08257c.chunk.js.map