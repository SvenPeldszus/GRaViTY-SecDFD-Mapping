package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'EDFD'", "'['", "'assets:'", "','", "'elements:'", "'attack'", "'zones:'", "']'", "'attacker'", "'profiles:'", "'subzones:'", "'observation:'", "'Asset'", "'type:'", "'values:'", "'source:'", "'targets:'", "'Process'", "'responsibilities:'", "'assumption:'", "'incoming'", "'flows:'", "'outgoing'", "'attacker:'", "'::'", "'ExternalEntity'", "'num:'", "'channel'", "'DataStore'", "'layer:'", "'true'", "'false'", "'-'", "'H'", "'M'", "'L'", "'I'", "'C'", "'Av'", "'Ac'", "'Transport'", "'Architectural'", "'Application'", "'Store'", "'Comparator'", "'Discarder'", "'Joiner'", "'Copier'", "'Splitter'", "'Forward'", "'EncryptOrHash'", "'Decrypt'", "'Authenticator'", "'Authoriser'", "'Verifier'", "'User'", "'VLAN'", "'ETH'", "'WiFi'", "'String'", "'Number'", "'Object'", "'Vector'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "EDFD";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleEDFD"
    // InternalMyDsl.g:65:1: entryRuleEDFD returns [EObject current=null] : iv_ruleEDFD= ruleEDFD EOF ;
    public final EObject entryRuleEDFD() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDFD = null;


        try {
            // InternalMyDsl.g:65:45: (iv_ruleEDFD= ruleEDFD EOF )
            // InternalMyDsl.g:66:2: iv_ruleEDFD= ruleEDFD EOF
            {
             newCompositeNode(grammarAccess.getEDFDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDFD=ruleEDFD();

            state._fsp--;

             current =iv_ruleEDFD; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDFD"


    // $ANTLR start "ruleEDFD"
    // InternalMyDsl.g:72:1: ruleEDFD returns [EObject current=null] : ( () otherlv_1= 'EDFD' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( (lv_asset_5_0= ruleAsset ) ) (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )* )? (otherlv_8= 'elements:' ( (lv_elements_9_0= ruleElement ) ) (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )* )? (otherlv_12= 'attack' otherlv_13= 'zones:' ( (lv_trustzones_14_0= ruleTrustZone ) ) (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )* )? otherlv_17= ']' ) ;
    public final EObject ruleEDFD() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_asset_5_0 = null;

        EObject lv_asset_7_0 = null;

        EObject lv_elements_9_0 = null;

        EObject lv_elements_11_0 = null;

        EObject lv_trustzones_14_0 = null;

        EObject lv_trustzones_16_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:78:2: ( ( () otherlv_1= 'EDFD' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( (lv_asset_5_0= ruleAsset ) ) (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )* )? (otherlv_8= 'elements:' ( (lv_elements_9_0= ruleElement ) ) (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )* )? (otherlv_12= 'attack' otherlv_13= 'zones:' ( (lv_trustzones_14_0= ruleTrustZone ) ) (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )* )? otherlv_17= ']' ) )
            // InternalMyDsl.g:79:2: ( () otherlv_1= 'EDFD' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( (lv_asset_5_0= ruleAsset ) ) (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )* )? (otherlv_8= 'elements:' ( (lv_elements_9_0= ruleElement ) ) (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )* )? (otherlv_12= 'attack' otherlv_13= 'zones:' ( (lv_trustzones_14_0= ruleTrustZone ) ) (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )* )? otherlv_17= ']' )
            {
            // InternalMyDsl.g:79:2: ( () otherlv_1= 'EDFD' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( (lv_asset_5_0= ruleAsset ) ) (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )* )? (otherlv_8= 'elements:' ( (lv_elements_9_0= ruleElement ) ) (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )* )? (otherlv_12= 'attack' otherlv_13= 'zones:' ( (lv_trustzones_14_0= ruleTrustZone ) ) (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )* )? otherlv_17= ']' )
            // InternalMyDsl.g:80:3: () otherlv_1= 'EDFD' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( (lv_asset_5_0= ruleAsset ) ) (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )* )? (otherlv_8= 'elements:' ( (lv_elements_9_0= ruleElement ) ) (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )* )? (otherlv_12= 'attack' otherlv_13= 'zones:' ( (lv_trustzones_14_0= ruleTrustZone ) ) (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )* )? otherlv_17= ']'
            {
            // InternalMyDsl.g:80:3: ()
            // InternalMyDsl.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEDFDAccess().getEDFDAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getEDFDAccess().getEDFDKeyword_1());
            		
            // InternalMyDsl.g:91:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:92:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:92:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:93:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getEDFDAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEDFDRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getEDFDAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalMyDsl.g:114:3: (otherlv_4= 'assets:' ( (lv_asset_5_0= ruleAsset ) ) (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:115:4: otherlv_4= 'assets:' ( (lv_asset_5_0= ruleAsset ) ) (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )*
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getEDFDAccess().getAssetsKeyword_4_0());
                    			
                    // InternalMyDsl.g:119:4: ( (lv_asset_5_0= ruleAsset ) )
                    // InternalMyDsl.g:120:5: (lv_asset_5_0= ruleAsset )
                    {
                    // InternalMyDsl.g:120:5: (lv_asset_5_0= ruleAsset )
                    // InternalMyDsl.g:121:6: lv_asset_5_0= ruleAsset
                    {

                    						newCompositeNode(grammarAccess.getEDFDAccess().getAssetAssetParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_asset_5_0=ruleAsset();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEDFDRule());
                    						}
                    						add(
                    							current,
                    							"asset",
                    							lv_asset_5_0,
                    							"org.xtext.example.mydsl.MyDsl.Asset");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:138:4: (otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalMyDsl.g:139:5: otherlv_6= ',' ( (lv_asset_7_0= ruleAsset ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_6); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getEDFDAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalMyDsl.g:143:5: ( (lv_asset_7_0= ruleAsset ) )
                    	    // InternalMyDsl.g:144:6: (lv_asset_7_0= ruleAsset )
                    	    {
                    	    // InternalMyDsl.g:144:6: (lv_asset_7_0= ruleAsset )
                    	    // InternalMyDsl.g:145:7: lv_asset_7_0= ruleAsset
                    	    {

                    	    							newCompositeNode(grammarAccess.getEDFDAccess().getAssetAssetParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_asset_7_0=ruleAsset();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEDFDRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"asset",
                    	    								lv_asset_7_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Asset");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:164:3: (otherlv_8= 'elements:' ( (lv_elements_9_0= ruleElement ) ) (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMyDsl.g:165:4: otherlv_8= 'elements:' ( (lv_elements_9_0= ruleElement ) ) (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getEDFDAccess().getElementsKeyword_5_0());
                    			
                    // InternalMyDsl.g:169:4: ( (lv_elements_9_0= ruleElement ) )
                    // InternalMyDsl.g:170:5: (lv_elements_9_0= ruleElement )
                    {
                    // InternalMyDsl.g:170:5: (lv_elements_9_0= ruleElement )
                    // InternalMyDsl.g:171:6: lv_elements_9_0= ruleElement
                    {

                    						newCompositeNode(grammarAccess.getEDFDAccess().getElementsElementParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_elements_9_0=ruleElement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEDFDRule());
                    						}
                    						add(
                    							current,
                    							"elements",
                    							lv_elements_9_0,
                    							"org.xtext.example.mydsl.MyDsl.Element");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:188:4: (otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==14) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalMyDsl.g:189:5: otherlv_10= ',' ( (lv_elements_11_0= ruleElement ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_8); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getEDFDAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMyDsl.g:193:5: ( (lv_elements_11_0= ruleElement ) )
                    	    // InternalMyDsl.g:194:6: (lv_elements_11_0= ruleElement )
                    	    {
                    	    // InternalMyDsl.g:194:6: (lv_elements_11_0= ruleElement )
                    	    // InternalMyDsl.g:195:7: lv_elements_11_0= ruleElement
                    	    {

                    	    							newCompositeNode(grammarAccess.getEDFDAccess().getElementsElementParserRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_elements_11_0=ruleElement();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEDFDRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_11_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Element");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:214:3: (otherlv_12= 'attack' otherlv_13= 'zones:' ( (lv_trustzones_14_0= ruleTrustZone ) ) (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:215:4: otherlv_12= 'attack' otherlv_13= 'zones:' ( (lv_trustzones_14_0= ruleTrustZone ) ) (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )*
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_10); 

                    				newLeafNode(otherlv_12, grammarAccess.getEDFDAccess().getAttackKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,17,FOLLOW_8); 

                    				newLeafNode(otherlv_13, grammarAccess.getEDFDAccess().getZonesKeyword_6_1());
                    			
                    // InternalMyDsl.g:223:4: ( (lv_trustzones_14_0= ruleTrustZone ) )
                    // InternalMyDsl.g:224:5: (lv_trustzones_14_0= ruleTrustZone )
                    {
                    // InternalMyDsl.g:224:5: (lv_trustzones_14_0= ruleTrustZone )
                    // InternalMyDsl.g:225:6: lv_trustzones_14_0= ruleTrustZone
                    {

                    						newCompositeNode(grammarAccess.getEDFDAccess().getTrustzonesTrustZoneParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_trustzones_14_0=ruleTrustZone();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEDFDRule());
                    						}
                    						add(
                    							current,
                    							"trustzones",
                    							lv_trustzones_14_0,
                    							"org.xtext.example.mydsl.MyDsl.TrustZone");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:242:4: (otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==14) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalMyDsl.g:243:5: otherlv_15= ',' ( (lv_trustzones_16_0= ruleTrustZone ) )
                    	    {
                    	    otherlv_15=(Token)match(input,14,FOLLOW_8); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getEDFDAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMyDsl.g:247:5: ( (lv_trustzones_16_0= ruleTrustZone ) )
                    	    // InternalMyDsl.g:248:6: (lv_trustzones_16_0= ruleTrustZone )
                    	    {
                    	    // InternalMyDsl.g:248:6: (lv_trustzones_16_0= ruleTrustZone )
                    	    // InternalMyDsl.g:249:7: lv_trustzones_16_0= ruleTrustZone
                    	    {

                    	    							newCompositeNode(grammarAccess.getEDFDAccess().getTrustzonesTrustZoneParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_trustzones_16_0=ruleTrustZone();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEDFDRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"trustzones",
                    	    								lv_trustzones_16_0,
                    	    								"org.xtext.example.mydsl.MyDsl.TrustZone");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_17=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getEDFDAccess().getRightSquareBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDFD"


    // $ANTLR start "entryRuleTrustZone"
    // InternalMyDsl.g:276:1: entryRuleTrustZone returns [EObject current=null] : iv_ruleTrustZone= ruleTrustZone EOF ;
    public final EObject entryRuleTrustZone() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrustZone = null;


        try {
            // InternalMyDsl.g:276:50: (iv_ruleTrustZone= ruleTrustZone EOF )
            // InternalMyDsl.g:277:2: iv_ruleTrustZone= ruleTrustZone EOF
            {
             newCompositeNode(grammarAccess.getTrustZoneRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrustZone=ruleTrustZone();

            state._fsp--;

             current =iv_ruleTrustZone; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrustZone"


    // $ANTLR start "ruleTrustZone"
    // InternalMyDsl.g:283:1: ruleTrustZone returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'attacker' otherlv_4= 'profiles:' ( (lv_attackerprofile_5_0= ruleAttackerProfile ) ) (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )* )? (otherlv_8= 'elements:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'subzones:' ( (lv_subzones_13_0= ruleTrustZone ) ) (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )* )? otherlv_16= ']' ) ;
    public final EObject ruleTrustZone() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_attackerprofile_5_0 = null;

        EObject lv_attackerprofile_7_0 = null;

        EObject lv_subzones_13_0 = null;

        EObject lv_subzones_15_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:289:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'attacker' otherlv_4= 'profiles:' ( (lv_attackerprofile_5_0= ruleAttackerProfile ) ) (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )* )? (otherlv_8= 'elements:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'subzones:' ( (lv_subzones_13_0= ruleTrustZone ) ) (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )* )? otherlv_16= ']' ) )
            // InternalMyDsl.g:290:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'attacker' otherlv_4= 'profiles:' ( (lv_attackerprofile_5_0= ruleAttackerProfile ) ) (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )* )? (otherlv_8= 'elements:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'subzones:' ( (lv_subzones_13_0= ruleTrustZone ) ) (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )* )? otherlv_16= ']' )
            {
            // InternalMyDsl.g:290:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'attacker' otherlv_4= 'profiles:' ( (lv_attackerprofile_5_0= ruleAttackerProfile ) ) (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )* )? (otherlv_8= 'elements:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'subzones:' ( (lv_subzones_13_0= ruleTrustZone ) ) (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )* )? otherlv_16= ']' )
            // InternalMyDsl.g:291:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'attacker' otherlv_4= 'profiles:' ( (lv_attackerprofile_5_0= ruleAttackerProfile ) ) (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )* )? (otherlv_8= 'elements:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'subzones:' ( (lv_subzones_13_0= ruleTrustZone ) ) (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )* )? otherlv_16= ']'
            {
            // InternalMyDsl.g:291:3: ()
            // InternalMyDsl.g:292:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrustZoneAccess().getTrustZoneAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:298:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:299:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:299:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:300:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTrustZoneAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTrustZoneRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getTrustZoneAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalMyDsl.g:321:3: (otherlv_3= 'attacker' otherlv_4= 'profiles:' ( (lv_attackerprofile_5_0= ruleAttackerProfile ) ) (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:322:4: otherlv_3= 'attacker' otherlv_4= 'profiles:' ( (lv_attackerprofile_5_0= ruleAttackerProfile ) ) (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getTrustZoneAccess().getAttackerKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getTrustZoneAccess().getProfilesKeyword_3_1());
                    			
                    // InternalMyDsl.g:330:4: ( (lv_attackerprofile_5_0= ruleAttackerProfile ) )
                    // InternalMyDsl.g:331:5: (lv_attackerprofile_5_0= ruleAttackerProfile )
                    {
                    // InternalMyDsl.g:331:5: (lv_attackerprofile_5_0= ruleAttackerProfile )
                    // InternalMyDsl.g:332:6: lv_attackerprofile_5_0= ruleAttackerProfile
                    {

                    						newCompositeNode(grammarAccess.getTrustZoneAccess().getAttackerprofileAttackerProfileParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_attackerprofile_5_0=ruleAttackerProfile();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTrustZoneRule());
                    						}
                    						add(
                    							current,
                    							"attackerprofile",
                    							lv_attackerprofile_5_0,
                    							"org.xtext.example.mydsl.MyDsl.AttackerProfile");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:349:4: (otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==14) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalMyDsl.g:350:5: otherlv_6= ',' ( (lv_attackerprofile_7_0= ruleAttackerProfile ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTrustZoneAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:354:5: ( (lv_attackerprofile_7_0= ruleAttackerProfile ) )
                    	    // InternalMyDsl.g:355:6: (lv_attackerprofile_7_0= ruleAttackerProfile )
                    	    {
                    	    // InternalMyDsl.g:355:6: (lv_attackerprofile_7_0= ruleAttackerProfile )
                    	    // InternalMyDsl.g:356:7: lv_attackerprofile_7_0= ruleAttackerProfile
                    	    {

                    	    							newCompositeNode(grammarAccess.getTrustZoneAccess().getAttackerprofileAttackerProfileParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_14);
                    	    lv_attackerprofile_7_0=ruleAttackerProfile();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTrustZoneRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attackerprofile",
                    	    								lv_attackerprofile_7_0,
                    	    								"org.xtext.example.mydsl.MyDsl.AttackerProfile");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:375:3: (otherlv_8= 'elements:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:376:4: otherlv_8= 'elements:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getTrustZoneAccess().getElementsKeyword_4_0());
                    			
                    // InternalMyDsl.g:380:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:381:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:381:5: ( ruleEString )
                    // InternalMyDsl.g:382:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTrustZoneRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:396:4: (otherlv_10= ',' ( ( ruleEString ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==14) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMyDsl.g:397:5: otherlv_10= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getTrustZoneAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalMyDsl.g:401:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:402:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:402:6: ( ruleEString )
                    	    // InternalMyDsl.g:403:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getTrustZoneRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:419:3: (otherlv_12= 'subzones:' ( (lv_subzones_13_0= ruleTrustZone ) ) (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMyDsl.g:420:4: otherlv_12= 'subzones:' ( (lv_subzones_13_0= ruleTrustZone ) ) (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )*
                    {
                    otherlv_12=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_12, grammarAccess.getTrustZoneAccess().getSubzonesKeyword_5_0());
                    			
                    // InternalMyDsl.g:424:4: ( (lv_subzones_13_0= ruleTrustZone ) )
                    // InternalMyDsl.g:425:5: (lv_subzones_13_0= ruleTrustZone )
                    {
                    // InternalMyDsl.g:425:5: (lv_subzones_13_0= ruleTrustZone )
                    // InternalMyDsl.g:426:6: lv_subzones_13_0= ruleTrustZone
                    {

                    						newCompositeNode(grammarAccess.getTrustZoneAccess().getSubzonesTrustZoneParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_subzones_13_0=ruleTrustZone();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTrustZoneRule());
                    						}
                    						add(
                    							current,
                    							"subzones",
                    							lv_subzones_13_0,
                    							"org.xtext.example.mydsl.MyDsl.TrustZone");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:443:4: (otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==14) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMyDsl.g:444:5: otherlv_14= ',' ( (lv_subzones_15_0= ruleTrustZone ) )
                    	    {
                    	    otherlv_14=(Token)match(input,14,FOLLOW_8); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getTrustZoneAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMyDsl.g:448:5: ( (lv_subzones_15_0= ruleTrustZone ) )
                    	    // InternalMyDsl.g:449:6: (lv_subzones_15_0= ruleTrustZone )
                    	    {
                    	    // InternalMyDsl.g:449:6: (lv_subzones_15_0= ruleTrustZone )
                    	    // InternalMyDsl.g:450:7: lv_subzones_15_0= ruleTrustZone
                    	    {

                    	    							newCompositeNode(grammarAccess.getTrustZoneAccess().getSubzonesTrustZoneParserRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_subzones_15_0=ruleTrustZone();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTrustZoneRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"subzones",
                    	    								lv_subzones_15_0,
                    	    								"org.xtext.example.mydsl.MyDsl.TrustZone");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getTrustZoneAccess().getRightSquareBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrustZone"


    // $ANTLR start "entryRuleAttackerProfile"
    // InternalMyDsl.g:477:1: entryRuleAttackerProfile returns [EObject current=null] : iv_ruleAttackerProfile= ruleAttackerProfile EOF ;
    public final EObject entryRuleAttackerProfile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttackerProfile = null;


        try {
            // InternalMyDsl.g:477:56: (iv_ruleAttackerProfile= ruleAttackerProfile EOF )
            // InternalMyDsl.g:478:2: iv_ruleAttackerProfile= ruleAttackerProfile EOF
            {
             newCompositeNode(grammarAccess.getAttackerProfileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttackerProfile=ruleAttackerProfile();

            state._fsp--;

             current =iv_ruleAttackerProfile; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttackerProfile"


    // $ANTLR start "ruleAttackerProfile"
    // InternalMyDsl.g:484:1: ruleAttackerProfile returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'observation:' ( (lv_Observation_4_0= ruleEInt ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleAttackerProfile() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_Observation_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:490:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'observation:' ( (lv_Observation_4_0= ruleEInt ) ) )? otherlv_5= ']' ) )
            // InternalMyDsl.g:491:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'observation:' ( (lv_Observation_4_0= ruleEInt ) ) )? otherlv_5= ']' )
            {
            // InternalMyDsl.g:491:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'observation:' ( (lv_Observation_4_0= ruleEInt ) ) )? otherlv_5= ']' )
            // InternalMyDsl.g:492:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'observation:' ( (lv_Observation_4_0= ruleEInt ) ) )? otherlv_5= ']'
            {
            // InternalMyDsl.g:492:3: ()
            // InternalMyDsl.g:493:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAttackerProfileAccess().getAttackerProfileAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:499:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:500:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:500:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:501:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAttackerProfileAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttackerProfileRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getAttackerProfileAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalMyDsl.g:522:3: (otherlv_3= 'observation:' ( (lv_Observation_4_0= ruleEInt ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:523:4: otherlv_3= 'observation:' ( (lv_Observation_4_0= ruleEInt ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_17); 

                    				newLeafNode(otherlv_3, grammarAccess.getAttackerProfileAccess().getObservationKeyword_3_0());
                    			
                    // InternalMyDsl.g:527:4: ( (lv_Observation_4_0= ruleEInt ) )
                    // InternalMyDsl.g:528:5: (lv_Observation_4_0= ruleEInt )
                    {
                    // InternalMyDsl.g:528:5: (lv_Observation_4_0= ruleEInt )
                    // InternalMyDsl.g:529:6: lv_Observation_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getAttackerProfileAccess().getObservationEIntParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_Observation_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttackerProfileRule());
                    						}
                    						set(
                    							current,
                    							"Observation",
                    							lv_Observation_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getAttackerProfileAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttackerProfile"


    // $ANTLR start "entryRuleAsset"
    // InternalMyDsl.g:555:1: entryRuleAsset returns [EObject current=null] : iv_ruleAsset= ruleAsset EOF ;
    public final EObject entryRuleAsset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsset = null;


        try {
            // InternalMyDsl.g:555:46: (iv_ruleAsset= ruleAsset EOF )
            // InternalMyDsl.g:556:2: iv_ruleAsset= ruleAsset EOF
            {
             newCompositeNode(grammarAccess.getAssetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAsset=ruleAsset();

            state._fsp--;

             current =iv_ruleAsset; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAsset"


    // $ANTLR start "ruleAsset"
    // InternalMyDsl.g:562:1: ruleAsset returns [EObject current=null] : ( () otherlv_1= 'Asset' ( (lv_name_2_0= ruleEString ) ) otherlv_3= 'type:' ( (lv_Type_4_0= ruleAssetType ) ) (otherlv_5= 'values:' ( (lv_value_6_0= ruleValue ) ) (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )* )? otherlv_9= 'source:' ( ( ruleEString ) ) otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* ) ;
    public final EObject ruleAsset() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_Type_4_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:568:2: ( ( () otherlv_1= 'Asset' ( (lv_name_2_0= ruleEString ) ) otherlv_3= 'type:' ( (lv_Type_4_0= ruleAssetType ) ) (otherlv_5= 'values:' ( (lv_value_6_0= ruleValue ) ) (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )* )? otherlv_9= 'source:' ( ( ruleEString ) ) otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* ) )
            // InternalMyDsl.g:569:2: ( () otherlv_1= 'Asset' ( (lv_name_2_0= ruleEString ) ) otherlv_3= 'type:' ( (lv_Type_4_0= ruleAssetType ) ) (otherlv_5= 'values:' ( (lv_value_6_0= ruleValue ) ) (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )* )? otherlv_9= 'source:' ( ( ruleEString ) ) otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )
            {
            // InternalMyDsl.g:569:2: ( () otherlv_1= 'Asset' ( (lv_name_2_0= ruleEString ) ) otherlv_3= 'type:' ( (lv_Type_4_0= ruleAssetType ) ) (otherlv_5= 'values:' ( (lv_value_6_0= ruleValue ) ) (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )* )? otherlv_9= 'source:' ( ( ruleEString ) ) otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )
            // InternalMyDsl.g:570:3: () otherlv_1= 'Asset' ( (lv_name_2_0= ruleEString ) ) otherlv_3= 'type:' ( (lv_Type_4_0= ruleAssetType ) ) (otherlv_5= 'values:' ( (lv_value_6_0= ruleValue ) ) (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )* )? otherlv_9= 'source:' ( ( ruleEString ) ) otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )*
            {
            // InternalMyDsl.g:570:3: ()
            // InternalMyDsl.g:571:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAssetAccess().getAssetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getAssetAccess().getAssetKeyword_1());
            		
            // InternalMyDsl.g:581:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:582:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:582:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:583:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAssetAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssetRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getAssetAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:604:3: ( (lv_Type_4_0= ruleAssetType ) )
            // InternalMyDsl.g:605:4: (lv_Type_4_0= ruleAssetType )
            {
            // InternalMyDsl.g:605:4: (lv_Type_4_0= ruleAssetType )
            // InternalMyDsl.g:606:5: lv_Type_4_0= ruleAssetType
            {

            					newCompositeNode(grammarAccess.getAssetAccess().getTypeAssetTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_Type_4_0=ruleAssetType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssetRule());
            					}
            					set(
            						current,
            						"Type",
            						lv_Type_4_0,
            						"org.xtext.example.mydsl.MyDsl.AssetType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:623:3: (otherlv_5= 'values:' ( (lv_value_6_0= ruleValue ) ) (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:624:4: otherlv_5= 'values:' ( (lv_value_6_0= ruleValue ) ) (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )*
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getAssetAccess().getValuesKeyword_5_0());
                    			
                    // InternalMyDsl.g:628:4: ( (lv_value_6_0= ruleValue ) )
                    // InternalMyDsl.g:629:5: (lv_value_6_0= ruleValue )
                    {
                    // InternalMyDsl.g:629:5: (lv_value_6_0= ruleValue )
                    // InternalMyDsl.g:630:6: lv_value_6_0= ruleValue
                    {

                    						newCompositeNode(grammarAccess.getAssetAccess().getValueValueParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_value_6_0=ruleValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssetRule());
                    						}
                    						add(
                    							current,
                    							"value",
                    							lv_value_6_0,
                    							"org.xtext.example.mydsl.MyDsl.Value");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:647:4: (otherlv_7= ',' ( (lv_value_8_0= ruleValue ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==14) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalMyDsl.g:648:5: otherlv_7= ',' ( (lv_value_8_0= ruleValue ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_4); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getAssetAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMyDsl.g:652:5: ( (lv_value_8_0= ruleValue ) )
                    	    // InternalMyDsl.g:653:6: (lv_value_8_0= ruleValue )
                    	    {
                    	    // InternalMyDsl.g:653:6: (lv_value_8_0= ruleValue )
                    	    // InternalMyDsl.g:654:7: lv_value_8_0= ruleValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getAssetAccess().getValueValueParserRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_value_8_0=ruleValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAssetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"value",
                    	    								lv_value_8_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Value");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getAssetAccess().getSourceKeyword_6());
            		
            // InternalMyDsl.g:677:3: ( ( ruleEString ) )
            // InternalMyDsl.g:678:4: ( ruleEString )
            {
            // InternalMyDsl.g:678:4: ( ruleEString )
            // InternalMyDsl.g:679:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssetRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssetAccess().getSourceElementCrossReference_7_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_11, grammarAccess.getAssetAccess().getTargetsKeyword_8());
            		
            // InternalMyDsl.g:697:3: ( ( ruleEString ) )
            // InternalMyDsl.g:698:4: ( ruleEString )
            {
            // InternalMyDsl.g:698:4: ( ruleEString )
            // InternalMyDsl.g:699:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssetRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssetAccess().getTargetsElementCrossReference_9_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:713:3: (otherlv_13= ',' ( ( ruleEString ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==14) ) {
                    int LA16_1 = input.LA(2);

                    if ( ((LA16_1>=RULE_STRING && LA16_1<=RULE_ID)) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // InternalMyDsl.g:714:4: otherlv_13= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_13=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_13, grammarAccess.getAssetAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalMyDsl.g:718:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:719:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:719:5: ( ruleEString )
            	    // InternalMyDsl.g:720:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getAssetRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getAssetAccess().getTargetsElementCrossReference_10_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAsset"


    // $ANTLR start "entryRuleProcess"
    // InternalMyDsl.g:739:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalMyDsl.g:739:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalMyDsl.g:740:2: iv_ruleProcess= ruleProcess EOF
            {
             newCompositeNode(grammarAccess.getProcessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;

             current =iv_ruleProcess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalMyDsl.g:746:1: ruleProcess returns [EObject current=null] : ( () otherlv_1= 'Process' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'responsibilities:' ( (lv_responsibility_5_0= ruleResponsibility ) ) (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )* )? (otherlv_8= 'assets:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'assumption:' ( (lv_assumption_13_0= ruleAssumption ) ) (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )* )? (otherlv_16= 'incoming' otherlv_17= 'flows:' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )? (otherlv_21= 'outgoing' otherlv_22= 'flows:' ( (lv_outflows_23_0= ruleFlow ) ) (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )* )? (otherlv_26= 'attacker:' ( (lv_Attacker_27_0= ruleEBoolean ) ) )? otherlv_28= ']' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_responsibility_5_0 = null;

        EObject lv_responsibility_7_0 = null;

        EObject lv_assumption_13_0 = null;

        EObject lv_assumption_15_0 = null;

        EObject lv_outflows_23_0 = null;

        EObject lv_outflows_25_0 = null;

        AntlrDatatypeRuleToken lv_Attacker_27_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:752:2: ( ( () otherlv_1= 'Process' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'responsibilities:' ( (lv_responsibility_5_0= ruleResponsibility ) ) (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )* )? (otherlv_8= 'assets:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'assumption:' ( (lv_assumption_13_0= ruleAssumption ) ) (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )* )? (otherlv_16= 'incoming' otherlv_17= 'flows:' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )? (otherlv_21= 'outgoing' otherlv_22= 'flows:' ( (lv_outflows_23_0= ruleFlow ) ) (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )* )? (otherlv_26= 'attacker:' ( (lv_Attacker_27_0= ruleEBoolean ) ) )? otherlv_28= ']' ) )
            // InternalMyDsl.g:753:2: ( () otherlv_1= 'Process' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'responsibilities:' ( (lv_responsibility_5_0= ruleResponsibility ) ) (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )* )? (otherlv_8= 'assets:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'assumption:' ( (lv_assumption_13_0= ruleAssumption ) ) (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )* )? (otherlv_16= 'incoming' otherlv_17= 'flows:' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )? (otherlv_21= 'outgoing' otherlv_22= 'flows:' ( (lv_outflows_23_0= ruleFlow ) ) (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )* )? (otherlv_26= 'attacker:' ( (lv_Attacker_27_0= ruleEBoolean ) ) )? otherlv_28= ']' )
            {
            // InternalMyDsl.g:753:2: ( () otherlv_1= 'Process' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'responsibilities:' ( (lv_responsibility_5_0= ruleResponsibility ) ) (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )* )? (otherlv_8= 'assets:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'assumption:' ( (lv_assumption_13_0= ruleAssumption ) ) (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )* )? (otherlv_16= 'incoming' otherlv_17= 'flows:' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )? (otherlv_21= 'outgoing' otherlv_22= 'flows:' ( (lv_outflows_23_0= ruleFlow ) ) (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )* )? (otherlv_26= 'attacker:' ( (lv_Attacker_27_0= ruleEBoolean ) ) )? otherlv_28= ']' )
            // InternalMyDsl.g:754:3: () otherlv_1= 'Process' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'responsibilities:' ( (lv_responsibility_5_0= ruleResponsibility ) ) (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )* )? (otherlv_8= 'assets:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )? (otherlv_12= 'assumption:' ( (lv_assumption_13_0= ruleAssumption ) ) (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )* )? (otherlv_16= 'incoming' otherlv_17= 'flows:' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )? (otherlv_21= 'outgoing' otherlv_22= 'flows:' ( (lv_outflows_23_0= ruleFlow ) ) (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )* )? (otherlv_26= 'attacker:' ( (lv_Attacker_27_0= ruleEBoolean ) ) )? otherlv_28= ']'
            {
            // InternalMyDsl.g:754:3: ()
            // InternalMyDsl.g:755:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProcessAccess().getProcessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getProcessAccess().getProcessKeyword_1());
            		
            // InternalMyDsl.g:765:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:766:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:766:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:767:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getProcessAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProcessRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_3, grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalMyDsl.g:788:3: (otherlv_4= 'responsibilities:' ( (lv_responsibility_5_0= ruleResponsibility ) ) (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMyDsl.g:789:4: otherlv_4= 'responsibilities:' ( (lv_responsibility_5_0= ruleResponsibility ) ) (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )*
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getProcessAccess().getResponsibilitiesKeyword_4_0());
                    			
                    // InternalMyDsl.g:793:4: ( (lv_responsibility_5_0= ruleResponsibility ) )
                    // InternalMyDsl.g:794:5: (lv_responsibility_5_0= ruleResponsibility )
                    {
                    // InternalMyDsl.g:794:5: (lv_responsibility_5_0= ruleResponsibility )
                    // InternalMyDsl.g:795:6: lv_responsibility_5_0= ruleResponsibility
                    {

                    						newCompositeNode(grammarAccess.getProcessAccess().getResponsibilityResponsibilityParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_responsibility_5_0=ruleResponsibility();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProcessRule());
                    						}
                    						add(
                    							current,
                    							"responsibility",
                    							lv_responsibility_5_0,
                    							"org.xtext.example.mydsl.MyDsl.Responsibility");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:812:4: (otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==14) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalMyDsl.g:813:5: otherlv_6= ',' ( (lv_responsibility_7_0= ruleResponsibility ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_4); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getProcessAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalMyDsl.g:817:5: ( (lv_responsibility_7_0= ruleResponsibility ) )
                    	    // InternalMyDsl.g:818:6: (lv_responsibility_7_0= ruleResponsibility )
                    	    {
                    	    // InternalMyDsl.g:818:6: (lv_responsibility_7_0= ruleResponsibility )
                    	    // InternalMyDsl.g:819:7: lv_responsibility_7_0= ruleResponsibility
                    	    {

                    	    							newCompositeNode(grammarAccess.getProcessAccess().getResponsibilityResponsibilityParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_26);
                    	    lv_responsibility_7_0=ruleResponsibility();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getProcessRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"responsibility",
                    	    								lv_responsibility_7_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Responsibility");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:838:3: (otherlv_8= 'assets:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==13) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMyDsl.g:839:4: otherlv_8= 'assets:' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_8=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getProcessAccess().getAssetsKeyword_5_0());
                    			
                    // InternalMyDsl.g:843:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:844:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:844:5: ( ruleEString )
                    // InternalMyDsl.g:845:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProcessRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:859:4: (otherlv_10= ',' ( ( ruleEString ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==14) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalMyDsl.g:860:5: otherlv_10= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getProcessAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMyDsl.g:864:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:865:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:865:6: ( ruleEString )
                    	    // InternalMyDsl.g:866:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getProcessRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_27);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:882:3: (otherlv_12= 'assumption:' ( (lv_assumption_13_0= ruleAssumption ) ) (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:883:4: otherlv_12= 'assumption:' ( (lv_assumption_13_0= ruleAssumption ) ) (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )*
                    {
                    otherlv_12=(Token)match(input,30,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getProcessAccess().getAssumptionKeyword_6_0());
                    			
                    // InternalMyDsl.g:887:4: ( (lv_assumption_13_0= ruleAssumption ) )
                    // InternalMyDsl.g:888:5: (lv_assumption_13_0= ruleAssumption )
                    {
                    // InternalMyDsl.g:888:5: (lv_assumption_13_0= ruleAssumption )
                    // InternalMyDsl.g:889:6: lv_assumption_13_0= ruleAssumption
                    {

                    						newCompositeNode(grammarAccess.getProcessAccess().getAssumptionAssumptionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_assumption_13_0=ruleAssumption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProcessRule());
                    						}
                    						add(
                    							current,
                    							"assumption",
                    							lv_assumption_13_0,
                    							"org.xtext.example.mydsl.MyDsl.Assumption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:906:4: (otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==14) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalMyDsl.g:907:5: otherlv_14= ',' ( (lv_assumption_15_0= ruleAssumption ) )
                    	    {
                    	    otherlv_14=(Token)match(input,14,FOLLOW_4); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getProcessAccess().getCommaKeyword_6_2_0());
                    	    				
                    	    // InternalMyDsl.g:911:5: ( (lv_assumption_15_0= ruleAssumption ) )
                    	    // InternalMyDsl.g:912:6: (lv_assumption_15_0= ruleAssumption )
                    	    {
                    	    // InternalMyDsl.g:912:6: (lv_assumption_15_0= ruleAssumption )
                    	    // InternalMyDsl.g:913:7: lv_assumption_15_0= ruleAssumption
                    	    {

                    	    							newCompositeNode(grammarAccess.getProcessAccess().getAssumptionAssumptionParserRuleCall_6_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
                    	    lv_assumption_15_0=ruleAssumption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getProcessRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"assumption",
                    	    								lv_assumption_15_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Assumption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:932:3: (otherlv_16= 'incoming' otherlv_17= 'flows:' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:933:4: otherlv_16= 'incoming' otherlv_17= 'flows:' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_16=(Token)match(input,31,FOLLOW_29); 

                    				newLeafNode(otherlv_16, grammarAccess.getProcessAccess().getIncomingKeyword_7_0());
                    			
                    otherlv_17=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_17, grammarAccess.getProcessAccess().getFlowsKeyword_7_1());
                    			
                    // InternalMyDsl.g:941:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:942:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:942:5: ( ruleEString )
                    // InternalMyDsl.g:943:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProcessRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_2_0());
                    					
                    pushFollow(FOLLOW_30);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:957:4: (otherlv_19= ',' ( ( ruleEString ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==14) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalMyDsl.g:958:5: otherlv_19= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_19=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_19, grammarAccess.getProcessAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:962:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:963:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:963:6: ( ruleEString )
                    	    // InternalMyDsl.g:964:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getProcessRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_30);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:980:3: (otherlv_21= 'outgoing' otherlv_22= 'flows:' ( (lv_outflows_23_0= ruleFlow ) ) (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:981:4: otherlv_21= 'outgoing' otherlv_22= 'flows:' ( (lv_outflows_23_0= ruleFlow ) ) (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )*
                    {
                    otherlv_21=(Token)match(input,33,FOLLOW_29); 

                    				newLeafNode(otherlv_21, grammarAccess.getProcessAccess().getOutgoingKeyword_8_0());
                    			
                    otherlv_22=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_22, grammarAccess.getProcessAccess().getFlowsKeyword_8_1());
                    			
                    // InternalMyDsl.g:989:4: ( (lv_outflows_23_0= ruleFlow ) )
                    // InternalMyDsl.g:990:5: (lv_outflows_23_0= ruleFlow )
                    {
                    // InternalMyDsl.g:990:5: (lv_outflows_23_0= ruleFlow )
                    // InternalMyDsl.g:991:6: lv_outflows_23_0= ruleFlow
                    {

                    						newCompositeNode(grammarAccess.getProcessAccess().getOutflowsFlowParserRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_outflows_23_0=ruleFlow();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProcessRule());
                    						}
                    						add(
                    							current,
                    							"outflows",
                    							lv_outflows_23_0,
                    							"org.xtext.example.mydsl.MyDsl.Flow");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1008:4: (otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==14) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalMyDsl.g:1009:5: otherlv_24= ',' ( (lv_outflows_25_0= ruleFlow ) )
                    	    {
                    	    otherlv_24=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getProcessAccess().getCommaKeyword_8_3_0());
                    	    				
                    	    // InternalMyDsl.g:1013:5: ( (lv_outflows_25_0= ruleFlow ) )
                    	    // InternalMyDsl.g:1014:6: (lv_outflows_25_0= ruleFlow )
                    	    {
                    	    // InternalMyDsl.g:1014:6: (lv_outflows_25_0= ruleFlow )
                    	    // InternalMyDsl.g:1015:7: lv_outflows_25_0= ruleFlow
                    	    {

                    	    							newCompositeNode(grammarAccess.getProcessAccess().getOutflowsFlowParserRuleCall_8_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_31);
                    	    lv_outflows_25_0=ruleFlow();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getProcessRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"outflows",
                    	    								lv_outflows_25_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Flow");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1034:3: (otherlv_26= 'attacker:' ( (lv_Attacker_27_0= ruleEBoolean ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:1035:4: otherlv_26= 'attacker:' ( (lv_Attacker_27_0= ruleEBoolean ) )
                    {
                    otherlv_26=(Token)match(input,34,FOLLOW_32); 

                    				newLeafNode(otherlv_26, grammarAccess.getProcessAccess().getAttackerKeyword_9_0());
                    			
                    // InternalMyDsl.g:1039:4: ( (lv_Attacker_27_0= ruleEBoolean ) )
                    // InternalMyDsl.g:1040:5: (lv_Attacker_27_0= ruleEBoolean )
                    {
                    // InternalMyDsl.g:1040:5: (lv_Attacker_27_0= ruleEBoolean )
                    // InternalMyDsl.g:1041:6: lv_Attacker_27_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getProcessAccess().getAttackerEBooleanParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_Attacker_27_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProcessRule());
                    						}
                    						set(
                    							current,
                    							"Attacker",
                    							lv_Attacker_27_0,
                    							"org.xtext.example.mydsl.MyDsl.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_28=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_28, grammarAccess.getProcessAccess().getRightSquareBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleResponsibility"
    // InternalMyDsl.g:1067:1: entryRuleResponsibility returns [EObject current=null] : iv_ruleResponsibility= ruleResponsibility EOF ;
    public final EObject entryRuleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResponsibility = null;


        try {
            // InternalMyDsl.g:1067:55: (iv_ruleResponsibility= ruleResponsibility EOF )
            // InternalMyDsl.g:1068:2: iv_ruleResponsibility= ruleResponsibility EOF
            {
             newCompositeNode(grammarAccess.getResponsibilityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResponsibility=ruleResponsibility();

            state._fsp--;

             current =iv_ruleResponsibility; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResponsibility"


    // $ANTLR start "ruleResponsibility"
    // InternalMyDsl.g:1074:1: ruleResponsibility returns [EObject current=null] : ( () otherlv_1= '[' ( ( ( ruleEString ) )? (otherlv_3= ',' ( ( ruleEString ) ) )* ( (lv_Action_5_0= ruleResponsibilityType ) ) otherlv_6= '::' ( ( ruleEString ) )? (otherlv_8= ',' ( ( ruleEString ) ) )* )? otherlv_10= ']' ) ;
    public final EObject ruleResponsibility() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_Action_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1080:2: ( ( () otherlv_1= '[' ( ( ( ruleEString ) )? (otherlv_3= ',' ( ( ruleEString ) ) )* ( (lv_Action_5_0= ruleResponsibilityType ) ) otherlv_6= '::' ( ( ruleEString ) )? (otherlv_8= ',' ( ( ruleEString ) ) )* )? otherlv_10= ']' ) )
            // InternalMyDsl.g:1081:2: ( () otherlv_1= '[' ( ( ( ruleEString ) )? (otherlv_3= ',' ( ( ruleEString ) ) )* ( (lv_Action_5_0= ruleResponsibilityType ) ) otherlv_6= '::' ( ( ruleEString ) )? (otherlv_8= ',' ( ( ruleEString ) ) )* )? otherlv_10= ']' )
            {
            // InternalMyDsl.g:1081:2: ( () otherlv_1= '[' ( ( ( ruleEString ) )? (otherlv_3= ',' ( ( ruleEString ) ) )* ( (lv_Action_5_0= ruleResponsibilityType ) ) otherlv_6= '::' ( ( ruleEString ) )? (otherlv_8= ',' ( ( ruleEString ) ) )* )? otherlv_10= ']' )
            // InternalMyDsl.g:1082:3: () otherlv_1= '[' ( ( ( ruleEString ) )? (otherlv_3= ',' ( ( ruleEString ) ) )* ( (lv_Action_5_0= ruleResponsibilityType ) ) otherlv_6= '::' ( ( ruleEString ) )? (otherlv_8= ',' ( ( ruleEString ) ) )* )? otherlv_10= ']'
            {
            // InternalMyDsl.g:1082:3: ()
            // InternalMyDsl.g:1083:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getResponsibilityAccess().getResponsibilityAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getResponsibilityAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalMyDsl.g:1093:3: ( ( ( ruleEString ) )? (otherlv_3= ',' ( ( ruleEString ) ) )* ( (lv_Action_5_0= ruleResponsibilityType ) ) otherlv_6= '::' ( ( ruleEString ) )? (otherlv_8= ',' ( ( ruleEString ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)||LA32_0==14||(LA32_0>=54 && LA32_0<=66)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:1094:4: ( ( ruleEString ) )? (otherlv_3= ',' ( ( ruleEString ) ) )* ( (lv_Action_5_0= ruleResponsibilityType ) ) otherlv_6= '::' ( ( ruleEString ) )? (otherlv_8= ',' ( ( ruleEString ) ) )*
                    {
                    // InternalMyDsl.g:1094:4: ( ( ruleEString ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_ID)) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalMyDsl.g:1095:5: ( ruleEString )
                            {
                            // InternalMyDsl.g:1095:5: ( ruleEString )
                            // InternalMyDsl.g:1096:6: ruleEString
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getResponsibilityRule());
                            						}
                            					

                            						newCompositeNode(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_0_0());
                            					
                            pushFollow(FOLLOW_34);
                            ruleEString();

                            state._fsp--;


                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalMyDsl.g:1110:4: (otherlv_3= ',' ( ( ruleEString ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==14) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalMyDsl.g:1111:5: otherlv_3= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getResponsibilityAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalMyDsl.g:1115:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1116:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1116:6: ( ruleEString )
                    	    // InternalMyDsl.g:1117:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getResponsibilityRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    // InternalMyDsl.g:1132:4: ( (lv_Action_5_0= ruleResponsibilityType ) )
                    // InternalMyDsl.g:1133:5: (lv_Action_5_0= ruleResponsibilityType )
                    {
                    // InternalMyDsl.g:1133:5: (lv_Action_5_0= ruleResponsibilityType )
                    // InternalMyDsl.g:1134:6: lv_Action_5_0= ruleResponsibilityType
                    {

                    						newCompositeNode(grammarAccess.getResponsibilityAccess().getActionResponsibilityTypeEnumRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_Action_5_0=ruleResponsibilityType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getResponsibilityRule());
                    						}
                    						add(
                    							current,
                    							"Action",
                    							lv_Action_5_0,
                    							"org.xtext.example.mydsl.MyDsl.ResponsibilityType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,35,FOLLOW_36); 

                    				newLeafNode(otherlv_6, grammarAccess.getResponsibilityAccess().getColonColonKeyword_2_3());
                    			
                    // InternalMyDsl.g:1155:4: ( ( ruleEString ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_ID)) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalMyDsl.g:1156:5: ( ruleEString )
                            {
                            // InternalMyDsl.g:1156:5: ( ruleEString )
                            // InternalMyDsl.g:1157:6: ruleEString
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getResponsibilityRule());
                            						}
                            					

                            						newCompositeNode(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_4_0());
                            					
                            pushFollow(FOLLOW_11);
                            ruleEString();

                            state._fsp--;


                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalMyDsl.g:1171:4: (otherlv_8= ',' ( ( ruleEString ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==14) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalMyDsl.g:1172:5: otherlv_8= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_8=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getResponsibilityAccess().getCommaKeyword_2_5_0());
                    	    				
                    	    // InternalMyDsl.g:1176:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1177:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1177:6: ( ruleEString )
                    	    // InternalMyDsl.g:1178:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getResponsibilityRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_5_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getResponsibilityAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResponsibility"


    // $ANTLR start "entryRuleExternalEntity"
    // InternalMyDsl.g:1202:1: entryRuleExternalEntity returns [EObject current=null] : iv_ruleExternalEntity= ruleExternalEntity EOF ;
    public final EObject entryRuleExternalEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalEntity = null;


        try {
            // InternalMyDsl.g:1202:55: (iv_ruleExternalEntity= ruleExternalEntity EOF )
            // InternalMyDsl.g:1203:2: iv_ruleExternalEntity= ruleExternalEntity EOF
            {
             newCompositeNode(grammarAccess.getExternalEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalEntity=ruleExternalEntity();

            state._fsp--;

             current =iv_ruleExternalEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalEntity"


    // $ANTLR start "ruleExternalEntity"
    // InternalMyDsl.g:1209:1: ruleExternalEntity returns [EObject current=null] : ( () otherlv_1= 'ExternalEntity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' ) ;
    public final EObject ruleExternalEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_assumption_9_0 = null;

        EObject lv_assumption_11_0 = null;

        EObject lv_outflows_19_0 = null;

        EObject lv_outflows_21_0 = null;

        AntlrDatatypeRuleToken lv_Attacker_23_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1215:2: ( ( () otherlv_1= 'ExternalEntity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' ) )
            // InternalMyDsl.g:1216:2: ( () otherlv_1= 'ExternalEntity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' )
            {
            // InternalMyDsl.g:1216:2: ( () otherlv_1= 'ExternalEntity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' )
            // InternalMyDsl.g:1217:3: () otherlv_1= 'ExternalEntity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']'
            {
            // InternalMyDsl.g:1217:3: ()
            // InternalMyDsl.g:1218:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalEntityAccess().getExternalEntityAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalEntityAccess().getExternalEntityKeyword_1());
            		
            // InternalMyDsl.g:1228:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:1229:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:1229:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:1230:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getExternalEntityAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExternalEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_37); 

            			newLeafNode(otherlv_3, grammarAccess.getExternalEntityAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalMyDsl.g:1251:3: (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==13) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMyDsl.g:1252:4: otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getExternalEntityAccess().getAssetsKeyword_4_0());
                    			
                    // InternalMyDsl.g:1256:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1257:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1257:5: ( ruleEString )
                    // InternalMyDsl.g:1258:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExternalEntityRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1272:4: (otherlv_6= ',' ( ( ruleEString ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==14) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalMyDsl.g:1273:5: otherlv_6= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getExternalEntityAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalMyDsl.g:1277:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1278:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1278:6: ( ruleEString )
                    	    // InternalMyDsl.g:1279:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getExternalEntityRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_27);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1295:3: (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==30) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMyDsl.g:1296:4: otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )*
                    {
                    otherlv_8=(Token)match(input,30,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getExternalEntityAccess().getAssumptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:1300:4: ( (lv_assumption_9_0= ruleAssumption ) )
                    // InternalMyDsl.g:1301:5: (lv_assumption_9_0= ruleAssumption )
                    {
                    // InternalMyDsl.g:1301:5: (lv_assumption_9_0= ruleAssumption )
                    // InternalMyDsl.g:1302:6: lv_assumption_9_0= ruleAssumption
                    {

                    						newCompositeNode(grammarAccess.getExternalEntityAccess().getAssumptionAssumptionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_assumption_9_0=ruleAssumption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExternalEntityRule());
                    						}
                    						add(
                    							current,
                    							"assumption",
                    							lv_assumption_9_0,
                    							"org.xtext.example.mydsl.MyDsl.Assumption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1319:4: (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==14) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalMyDsl.g:1320:5: otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_4); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getExternalEntityAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMyDsl.g:1324:5: ( (lv_assumption_11_0= ruleAssumption ) )
                    	    // InternalMyDsl.g:1325:6: (lv_assumption_11_0= ruleAssumption )
                    	    {
                    	    // InternalMyDsl.g:1325:6: (lv_assumption_11_0= ruleAssumption )
                    	    // InternalMyDsl.g:1326:7: lv_assumption_11_0= ruleAssumption
                    	    {

                    	    							newCompositeNode(grammarAccess.getExternalEntityAccess().getAssumptionAssumptionParserRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
                    	    lv_assumption_11_0=ruleAssumption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExternalEntityRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"assumption",
                    	    								lv_assumption_11_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Assumption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1345:3: (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==31) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalMyDsl.g:1346:4: otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_12=(Token)match(input,31,FOLLOW_29); 

                    				newLeafNode(otherlv_12, grammarAccess.getExternalEntityAccess().getIncomingKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getExternalEntityAccess().getFlowsKeyword_6_1());
                    			
                    // InternalMyDsl.g:1354:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1355:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1355:5: ( ruleEString )
                    // InternalMyDsl.g:1356:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExternalEntityRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_2_0());
                    					
                    pushFollow(FOLLOW_30);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1370:4: (otherlv_15= ',' ( ( ruleEString ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==14) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalMyDsl.g:1371:5: otherlv_15= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_15=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getExternalEntityAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMyDsl.g:1375:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1376:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1376:6: ( ruleEString )
                    	    // InternalMyDsl.g:1377:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getExternalEntityRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_30);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1393:3: (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==33) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:1394:4: otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )*
                    {
                    otherlv_17=(Token)match(input,33,FOLLOW_29); 

                    				newLeafNode(otherlv_17, grammarAccess.getExternalEntityAccess().getOutgoingKeyword_7_0());
                    			
                    otherlv_18=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getExternalEntityAccess().getFlowsKeyword_7_1());
                    			
                    // InternalMyDsl.g:1402:4: ( (lv_outflows_19_0= ruleFlow ) )
                    // InternalMyDsl.g:1403:5: (lv_outflows_19_0= ruleFlow )
                    {
                    // InternalMyDsl.g:1403:5: (lv_outflows_19_0= ruleFlow )
                    // InternalMyDsl.g:1404:6: lv_outflows_19_0= ruleFlow
                    {

                    						newCompositeNode(grammarAccess.getExternalEntityAccess().getOutflowsFlowParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_outflows_19_0=ruleFlow();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExternalEntityRule());
                    						}
                    						add(
                    							current,
                    							"outflows",
                    							lv_outflows_19_0,
                    							"org.xtext.example.mydsl.MyDsl.Flow");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1421:4: (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==14) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalMyDsl.g:1422:5: otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) )
                    	    {
                    	    otherlv_20=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getExternalEntityAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:1426:5: ( (lv_outflows_21_0= ruleFlow ) )
                    	    // InternalMyDsl.g:1427:6: (lv_outflows_21_0= ruleFlow )
                    	    {
                    	    // InternalMyDsl.g:1427:6: (lv_outflows_21_0= ruleFlow )
                    	    // InternalMyDsl.g:1428:7: lv_outflows_21_0= ruleFlow
                    	    {

                    	    							newCompositeNode(grammarAccess.getExternalEntityAccess().getOutflowsFlowParserRuleCall_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_31);
                    	    lv_outflows_21_0=ruleFlow();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExternalEntityRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"outflows",
                    	    								lv_outflows_21_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Flow");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1447:3: (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==34) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalMyDsl.g:1448:4: otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) )
                    {
                    otherlv_22=(Token)match(input,34,FOLLOW_32); 

                    				newLeafNode(otherlv_22, grammarAccess.getExternalEntityAccess().getAttackerKeyword_8_0());
                    			
                    // InternalMyDsl.g:1452:4: ( (lv_Attacker_23_0= ruleEBoolean ) )
                    // InternalMyDsl.g:1453:5: (lv_Attacker_23_0= ruleEBoolean )
                    {
                    // InternalMyDsl.g:1453:5: (lv_Attacker_23_0= ruleEBoolean )
                    // InternalMyDsl.g:1454:6: lv_Attacker_23_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getExternalEntityAccess().getAttackerEBooleanParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_Attacker_23_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExternalEntityRule());
                    						}
                    						set(
                    							current,
                    							"Attacker",
                    							lv_Attacker_23_0,
                    							"org.xtext.example.mydsl.MyDsl.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_24=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_24, grammarAccess.getExternalEntityAccess().getRightSquareBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalEntity"


    // $ANTLR start "entryRuleFlow"
    // InternalMyDsl.g:1480:1: entryRuleFlow returns [EObject current=null] : iv_ruleFlow= ruleFlow EOF ;
    public final EObject entryRuleFlow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlow = null;


        try {
            // InternalMyDsl.g:1480:45: (iv_ruleFlow= ruleFlow EOF )
            // InternalMyDsl.g:1481:2: iv_ruleFlow= ruleFlow EOF
            {
             newCompositeNode(grammarAccess.getFlowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFlow=ruleFlow();

            state._fsp--;

             current =iv_ruleFlow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlow"


    // $ANTLR start "ruleFlow"
    // InternalMyDsl.g:1487:1: ruleFlow returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'num:' ( (lv_number_4_0= ruleEInt ) ) )? (otherlv_5= 'assets:' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* )? (otherlv_9= 'source:' ( ( ruleEString ) ) )? (otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )? (otherlv_15= 'channel' ( (lv_Channel_16_0= ruleChannel ) ) )? (otherlv_17= 'assumption:' ( (lv_assumption_18_0= ruleAssumption ) ) (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )* )? otherlv_21= ']' ) ;
    public final EObject ruleFlow() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_number_4_0 = null;

        Enumerator lv_Channel_16_0 = null;

        EObject lv_assumption_18_0 = null;

        EObject lv_assumption_20_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1493:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'num:' ( (lv_number_4_0= ruleEInt ) ) )? (otherlv_5= 'assets:' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* )? (otherlv_9= 'source:' ( ( ruleEString ) ) )? (otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )? (otherlv_15= 'channel' ( (lv_Channel_16_0= ruleChannel ) ) )? (otherlv_17= 'assumption:' ( (lv_assumption_18_0= ruleAssumption ) ) (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )* )? otherlv_21= ']' ) )
            // InternalMyDsl.g:1494:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'num:' ( (lv_number_4_0= ruleEInt ) ) )? (otherlv_5= 'assets:' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* )? (otherlv_9= 'source:' ( ( ruleEString ) ) )? (otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )? (otherlv_15= 'channel' ( (lv_Channel_16_0= ruleChannel ) ) )? (otherlv_17= 'assumption:' ( (lv_assumption_18_0= ruleAssumption ) ) (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )* )? otherlv_21= ']' )
            {
            // InternalMyDsl.g:1494:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'num:' ( (lv_number_4_0= ruleEInt ) ) )? (otherlv_5= 'assets:' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* )? (otherlv_9= 'source:' ( ( ruleEString ) ) )? (otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )? (otherlv_15= 'channel' ( (lv_Channel_16_0= ruleChannel ) ) )? (otherlv_17= 'assumption:' ( (lv_assumption_18_0= ruleAssumption ) ) (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )* )? otherlv_21= ']' )
            // InternalMyDsl.g:1495:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= '[' (otherlv_3= 'num:' ( (lv_number_4_0= ruleEInt ) ) )? (otherlv_5= 'assets:' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* )? (otherlv_9= 'source:' ( ( ruleEString ) ) )? (otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )? (otherlv_15= 'channel' ( (lv_Channel_16_0= ruleChannel ) ) )? (otherlv_17= 'assumption:' ( (lv_assumption_18_0= ruleAssumption ) ) (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )* )? otherlv_21= ']'
            {
            // InternalMyDsl.g:1495:3: ()
            // InternalMyDsl.g:1496:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFlowAccess().getFlowAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1502:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1503:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1503:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1504:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFlowAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFlowRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getFlowAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalMyDsl.g:1525:3: (otherlv_3= 'num:' ( (lv_number_4_0= ruleEInt ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==37) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMyDsl.g:1526:4: otherlv_3= 'num:' ( (lv_number_4_0= ruleEInt ) )
                    {
                    otherlv_3=(Token)match(input,37,FOLLOW_17); 

                    				newLeafNode(otherlv_3, grammarAccess.getFlowAccess().getNumKeyword_3_0());
                    			
                    // InternalMyDsl.g:1530:4: ( (lv_number_4_0= ruleEInt ) )
                    // InternalMyDsl.g:1531:5: (lv_number_4_0= ruleEInt )
                    {
                    // InternalMyDsl.g:1531:5: (lv_number_4_0= ruleEInt )
                    // InternalMyDsl.g:1532:6: lv_number_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getFlowAccess().getNumberEIntParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_number_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFlowRule());
                    						}
                    						set(
                    							current,
                    							"number",
                    							lv_number_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1550:3: (otherlv_5= 'assets:' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==13) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMyDsl.g:1551:4: otherlv_5= 'assets:' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getFlowAccess().getAssetsKeyword_4_0());
                    			
                    // InternalMyDsl.g:1555:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1556:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1556:5: ( ruleEString )
                    // InternalMyDsl.g:1557:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFlowRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1571:4: (otherlv_7= ',' ( ( ruleEString ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==14) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalMyDsl.g:1572:5: otherlv_7= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getFlowAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalMyDsl.g:1576:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1577:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1577:6: ( ruleEString )
                    	    // InternalMyDsl.g:1578:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getFlowRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_40);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1594:3: (otherlv_9= 'source:' ( ( ruleEString ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==26) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMyDsl.g:1595:4: otherlv_9= 'source:' ( ( ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,26,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getFlowAccess().getSourceKeyword_5_0());
                    			
                    // InternalMyDsl.g:1599:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1600:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1600:5: ( ruleEString )
                    // InternalMyDsl.g:1601:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFlowRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFlowAccess().getSourceElementCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1616:3: (otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==27) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalMyDsl.g:1617:4: otherlv_11= 'targets:' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_11=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getFlowAccess().getTargetsKeyword_6_0());
                    			
                    // InternalMyDsl.g:1621:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1622:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1622:5: ( ruleEString )
                    // InternalMyDsl.g:1623:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFlowRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_42);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1637:4: (otherlv_13= ',' ( ( ruleEString ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==14) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalMyDsl.g:1638:5: otherlv_13= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_13=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getFlowAccess().getCommaKeyword_6_2_0());
                    	    				
                    	    // InternalMyDsl.g:1642:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1643:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1643:6: ( ruleEString )
                    	    // InternalMyDsl.g:1644:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getFlowRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_42);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1660:3: (otherlv_15= 'channel' ( (lv_Channel_16_0= ruleChannel ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==38) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalMyDsl.g:1661:4: otherlv_15= 'channel' ( (lv_Channel_16_0= ruleChannel ) )
                    {
                    otherlv_15=(Token)match(input,38,FOLLOW_43); 

                    				newLeafNode(otherlv_15, grammarAccess.getFlowAccess().getChannelKeyword_7_0());
                    			
                    // InternalMyDsl.g:1665:4: ( (lv_Channel_16_0= ruleChannel ) )
                    // InternalMyDsl.g:1666:5: (lv_Channel_16_0= ruleChannel )
                    {
                    // InternalMyDsl.g:1666:5: (lv_Channel_16_0= ruleChannel )
                    // InternalMyDsl.g:1667:6: lv_Channel_16_0= ruleChannel
                    {

                    						newCompositeNode(grammarAccess.getFlowAccess().getChannelChannelEnumRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_Channel_16_0=ruleChannel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFlowRule());
                    						}
                    						set(
                    							current,
                    							"Channel",
                    							lv_Channel_16_0,
                    							"org.xtext.example.mydsl.MyDsl.Channel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1685:3: (otherlv_17= 'assumption:' ( (lv_assumption_18_0= ruleAssumption ) ) (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==30) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalMyDsl.g:1686:4: otherlv_17= 'assumption:' ( (lv_assumption_18_0= ruleAssumption ) ) (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )*
                    {
                    otherlv_17=(Token)match(input,30,FOLLOW_4); 

                    				newLeafNode(otherlv_17, grammarAccess.getFlowAccess().getAssumptionKeyword_8_0());
                    			
                    // InternalMyDsl.g:1690:4: ( (lv_assumption_18_0= ruleAssumption ) )
                    // InternalMyDsl.g:1691:5: (lv_assumption_18_0= ruleAssumption )
                    {
                    // InternalMyDsl.g:1691:5: (lv_assumption_18_0= ruleAssumption )
                    // InternalMyDsl.g:1692:6: lv_assumption_18_0= ruleAssumption
                    {

                    						newCompositeNode(grammarAccess.getFlowAccess().getAssumptionAssumptionParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_assumption_18_0=ruleAssumption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFlowRule());
                    						}
                    						add(
                    							current,
                    							"assumption",
                    							lv_assumption_18_0,
                    							"org.xtext.example.mydsl.MyDsl.Assumption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1709:4: (otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==14) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalMyDsl.g:1710:5: otherlv_19= ',' ( (lv_assumption_20_0= ruleAssumption ) )
                    	    {
                    	    otherlv_19=(Token)match(input,14,FOLLOW_4); 

                    	    					newLeafNode(otherlv_19, grammarAccess.getFlowAccess().getCommaKeyword_8_2_0());
                    	    				
                    	    // InternalMyDsl.g:1714:5: ( (lv_assumption_20_0= ruleAssumption ) )
                    	    // InternalMyDsl.g:1715:6: (lv_assumption_20_0= ruleAssumption )
                    	    {
                    	    // InternalMyDsl.g:1715:6: (lv_assumption_20_0= ruleAssumption )
                    	    // InternalMyDsl.g:1716:7: lv_assumption_20_0= ruleAssumption
                    	    {

                    	    							newCompositeNode(grammarAccess.getFlowAccess().getAssumptionAssumptionParserRuleCall_8_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_assumption_20_0=ruleAssumption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFlowRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"assumption",
                    	    								lv_assumption_20_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Assumption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_21=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getFlowAccess().getRightSquareBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlow"


    // $ANTLR start "entryRuleDataStore"
    // InternalMyDsl.g:1743:1: entryRuleDataStore returns [EObject current=null] : iv_ruleDataStore= ruleDataStore EOF ;
    public final EObject entryRuleDataStore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStore = null;


        try {
            // InternalMyDsl.g:1743:50: (iv_ruleDataStore= ruleDataStore EOF )
            // InternalMyDsl.g:1744:2: iv_ruleDataStore= ruleDataStore EOF
            {
             newCompositeNode(grammarAccess.getDataStoreRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataStore=ruleDataStore();

            state._fsp--;

             current =iv_ruleDataStore; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataStore"


    // $ANTLR start "ruleDataStore"
    // InternalMyDsl.g:1750:1: ruleDataStore returns [EObject current=null] : ( () otherlv_1= 'DataStore' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' ) ;
    public final EObject ruleDataStore() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_assumption_9_0 = null;

        EObject lv_assumption_11_0 = null;

        EObject lv_outflows_19_0 = null;

        EObject lv_outflows_21_0 = null;

        AntlrDatatypeRuleToken lv_Attacker_23_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1756:2: ( ( () otherlv_1= 'DataStore' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' ) )
            // InternalMyDsl.g:1757:2: ( () otherlv_1= 'DataStore' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' )
            {
            // InternalMyDsl.g:1757:2: ( () otherlv_1= 'DataStore' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']' )
            // InternalMyDsl.g:1758:3: () otherlv_1= 'DataStore' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '[' (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )? (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )? (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )? (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )? (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )? otherlv_24= ']'
            {
            // InternalMyDsl.g:1758:3: ()
            // InternalMyDsl.g:1759:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataStoreAccess().getDataStoreAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDataStoreAccess().getDataStoreKeyword_1());
            		
            // InternalMyDsl.g:1769:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:1770:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:1770:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:1771:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataStoreAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataStoreRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_37); 

            			newLeafNode(otherlv_3, grammarAccess.getDataStoreAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalMyDsl.g:1792:3: (otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==13) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMyDsl.g:1793:4: otherlv_4= 'assets:' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getDataStoreAccess().getAssetsKeyword_4_0());
                    			
                    // InternalMyDsl.g:1797:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1798:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1798:5: ( ruleEString )
                    // InternalMyDsl.g:1799:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStoreRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1813:4: (otherlv_6= ',' ( ( ruleEString ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==14) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalMyDsl.g:1814:5: otherlv_6= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataStoreAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalMyDsl.g:1818:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1819:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1819:6: ( ruleEString )
                    	    // InternalMyDsl.g:1820:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getDataStoreRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_27);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1836:3: (otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==30) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMyDsl.g:1837:4: otherlv_8= 'assumption:' ( (lv_assumption_9_0= ruleAssumption ) ) (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )*
                    {
                    otherlv_8=(Token)match(input,30,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataStoreAccess().getAssumptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:1841:4: ( (lv_assumption_9_0= ruleAssumption ) )
                    // InternalMyDsl.g:1842:5: (lv_assumption_9_0= ruleAssumption )
                    {
                    // InternalMyDsl.g:1842:5: (lv_assumption_9_0= ruleAssumption )
                    // InternalMyDsl.g:1843:6: lv_assumption_9_0= ruleAssumption
                    {

                    						newCompositeNode(grammarAccess.getDataStoreAccess().getAssumptionAssumptionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_assumption_9_0=ruleAssumption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataStoreRule());
                    						}
                    						add(
                    							current,
                    							"assumption",
                    							lv_assumption_9_0,
                    							"org.xtext.example.mydsl.MyDsl.Assumption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1860:4: (otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==14) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalMyDsl.g:1861:5: otherlv_10= ',' ( (lv_assumption_11_0= ruleAssumption ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_4); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataStoreAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMyDsl.g:1865:5: ( (lv_assumption_11_0= ruleAssumption ) )
                    	    // InternalMyDsl.g:1866:6: (lv_assumption_11_0= ruleAssumption )
                    	    {
                    	    // InternalMyDsl.g:1866:6: (lv_assumption_11_0= ruleAssumption )
                    	    // InternalMyDsl.g:1867:7: lv_assumption_11_0= ruleAssumption
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStoreAccess().getAssumptionAssumptionParserRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
                    	    lv_assumption_11_0=ruleAssumption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataStoreRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"assumption",
                    	    								lv_assumption_11_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Assumption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1886:3: (otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==31) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalMyDsl.g:1887:4: otherlv_12= 'incoming' otherlv_13= 'flows:' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )*
                    {
                    otherlv_12=(Token)match(input,31,FOLLOW_29); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataStoreAccess().getIncomingKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getDataStoreAccess().getFlowsKeyword_6_1());
                    			
                    // InternalMyDsl.g:1895:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1896:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1896:5: ( ruleEString )
                    // InternalMyDsl.g:1897:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStoreRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_2_0());
                    					
                    pushFollow(FOLLOW_30);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1911:4: (otherlv_15= ',' ( ( ruleEString ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==14) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalMyDsl.g:1912:5: otherlv_15= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_15=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getDataStoreAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMyDsl.g:1916:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1917:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1917:6: ( ruleEString )
                    	    // InternalMyDsl.g:1918:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getDataStoreRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_30);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1934:3: (otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==33) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalMyDsl.g:1935:4: otherlv_17= 'outgoing' otherlv_18= 'flows:' ( (lv_outflows_19_0= ruleFlow ) ) (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )*
                    {
                    otherlv_17=(Token)match(input,33,FOLLOW_29); 

                    				newLeafNode(otherlv_17, grammarAccess.getDataStoreAccess().getOutgoingKeyword_7_0());
                    			
                    otherlv_18=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDataStoreAccess().getFlowsKeyword_7_1());
                    			
                    // InternalMyDsl.g:1943:4: ( (lv_outflows_19_0= ruleFlow ) )
                    // InternalMyDsl.g:1944:5: (lv_outflows_19_0= ruleFlow )
                    {
                    // InternalMyDsl.g:1944:5: (lv_outflows_19_0= ruleFlow )
                    // InternalMyDsl.g:1945:6: lv_outflows_19_0= ruleFlow
                    {

                    						newCompositeNode(grammarAccess.getDataStoreAccess().getOutflowsFlowParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_outflows_19_0=ruleFlow();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataStoreRule());
                    						}
                    						add(
                    							current,
                    							"outflows",
                    							lv_outflows_19_0,
                    							"org.xtext.example.mydsl.MyDsl.Flow");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1962:4: (otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==14) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalMyDsl.g:1963:5: otherlv_20= ',' ( (lv_outflows_21_0= ruleFlow ) )
                    	    {
                    	    otherlv_20=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getDataStoreAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:1967:5: ( (lv_outflows_21_0= ruleFlow ) )
                    	    // InternalMyDsl.g:1968:6: (lv_outflows_21_0= ruleFlow )
                    	    {
                    	    // InternalMyDsl.g:1968:6: (lv_outflows_21_0= ruleFlow )
                    	    // InternalMyDsl.g:1969:7: lv_outflows_21_0= ruleFlow
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStoreAccess().getOutflowsFlowParserRuleCall_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_31);
                    	    lv_outflows_21_0=ruleFlow();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataStoreRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"outflows",
                    	    								lv_outflows_21_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Flow");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1988:3: (otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==34) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMyDsl.g:1989:4: otherlv_22= 'attacker:' ( (lv_Attacker_23_0= ruleEBoolean ) )
                    {
                    otherlv_22=(Token)match(input,34,FOLLOW_32); 

                    				newLeafNode(otherlv_22, grammarAccess.getDataStoreAccess().getAttackerKeyword_8_0());
                    			
                    // InternalMyDsl.g:1993:4: ( (lv_Attacker_23_0= ruleEBoolean ) )
                    // InternalMyDsl.g:1994:5: (lv_Attacker_23_0= ruleEBoolean )
                    {
                    // InternalMyDsl.g:1994:5: (lv_Attacker_23_0= ruleEBoolean )
                    // InternalMyDsl.g:1995:6: lv_Attacker_23_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getDataStoreAccess().getAttackerEBooleanParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_Attacker_23_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataStoreRule());
                    						}
                    						set(
                    							current,
                    							"Attacker",
                    							lv_Attacker_23_0,
                    							"org.xtext.example.mydsl.MyDsl.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_24=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_24, grammarAccess.getDataStoreAccess().getRightSquareBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataStore"


    // $ANTLR start "entryRuleValue"
    // InternalMyDsl.g:2021:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalMyDsl.g:2021:46: (iv_ruleValue= ruleValue EOF )
            // InternalMyDsl.g:2022:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalMyDsl.g:2028:1: ruleValue returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_Priority_2_0= rulePriority ) )? ( (lv_Objective_3_0= ruleObjective ) )? otherlv_4= ']' ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Enumerator lv_Priority_2_0 = null;

        Enumerator lv_Objective_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2034:2: ( ( () otherlv_1= '[' ( (lv_Priority_2_0= rulePriority ) )? ( (lv_Objective_3_0= ruleObjective ) )? otherlv_4= ']' ) )
            // InternalMyDsl.g:2035:2: ( () otherlv_1= '[' ( (lv_Priority_2_0= rulePriority ) )? ( (lv_Objective_3_0= ruleObjective ) )? otherlv_4= ']' )
            {
            // InternalMyDsl.g:2035:2: ( () otherlv_1= '[' ( (lv_Priority_2_0= rulePriority ) )? ( (lv_Objective_3_0= ruleObjective ) )? otherlv_4= ']' )
            // InternalMyDsl.g:2036:3: () otherlv_1= '[' ( (lv_Priority_2_0= rulePriority ) )? ( (lv_Objective_3_0= ruleObjective ) )? otherlv_4= ']'
            {
            // InternalMyDsl.g:2036:3: ()
            // InternalMyDsl.g:2037:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueAccess().getValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getValueAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalMyDsl.g:2047:3: ( (lv_Priority_2_0= rulePriority ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=44 && LA60_0<=46)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalMyDsl.g:2048:4: (lv_Priority_2_0= rulePriority )
                    {
                    // InternalMyDsl.g:2048:4: (lv_Priority_2_0= rulePriority )
                    // InternalMyDsl.g:2049:5: lv_Priority_2_0= rulePriority
                    {

                    					newCompositeNode(grammarAccess.getValueAccess().getPriorityPriorityEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_46);
                    lv_Priority_2_0=rulePriority();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getValueRule());
                    					}
                    					set(
                    						current,
                    						"Priority",
                    						lv_Priority_2_0,
                    						"org.xtext.example.mydsl.MyDsl.Priority");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2066:3: ( (lv_Objective_3_0= ruleObjective ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=47 && LA61_0<=50)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalMyDsl.g:2067:4: (lv_Objective_3_0= ruleObjective )
                    {
                    // InternalMyDsl.g:2067:4: (lv_Objective_3_0= ruleObjective )
                    // InternalMyDsl.g:2068:5: lv_Objective_3_0= ruleObjective
                    {

                    					newCompositeNode(grammarAccess.getValueAccess().getObjectiveObjectiveEnumRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_18);
                    lv_Objective_3_0=ruleObjective();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getValueRule());
                    					}
                    					set(
                    						current,
                    						"Objective",
                    						lv_Objective_3_0,
                    						"org.xtext.example.mydsl.MyDsl.Objective");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getValueAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleAssumption"
    // InternalMyDsl.g:2093:1: entryRuleAssumption returns [EObject current=null] : iv_ruleAssumption= ruleAssumption EOF ;
    public final EObject entryRuleAssumption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssumption = null;


        try {
            // InternalMyDsl.g:2093:51: (iv_ruleAssumption= ruleAssumption EOF )
            // InternalMyDsl.g:2094:2: iv_ruleAssumption= ruleAssumption EOF
            {
             newCompositeNode(grammarAccess.getAssumptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssumption=ruleAssumption();

            state._fsp--;

             current =iv_ruleAssumption; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssumption"


    // $ANTLR start "ruleAssumption"
    // InternalMyDsl.g:2100:1: ruleAssumption returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_Objective_2_0= ruleObjective ) ) (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )* )? (otherlv_5= 'layer:' ( (lv_Layer_6_0= ruleLayer ) ) )? otherlv_7= ']' ) ;
    public final EObject ruleAssumption() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_Objective_2_0 = null;

        Enumerator lv_Objective_4_0 = null;

        Enumerator lv_Layer_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2106:2: ( ( () otherlv_1= '[' ( ( (lv_Objective_2_0= ruleObjective ) ) (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )* )? (otherlv_5= 'layer:' ( (lv_Layer_6_0= ruleLayer ) ) )? otherlv_7= ']' ) )
            // InternalMyDsl.g:2107:2: ( () otherlv_1= '[' ( ( (lv_Objective_2_0= ruleObjective ) ) (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )* )? (otherlv_5= 'layer:' ( (lv_Layer_6_0= ruleLayer ) ) )? otherlv_7= ']' )
            {
            // InternalMyDsl.g:2107:2: ( () otherlv_1= '[' ( ( (lv_Objective_2_0= ruleObjective ) ) (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )* )? (otherlv_5= 'layer:' ( (lv_Layer_6_0= ruleLayer ) ) )? otherlv_7= ']' )
            // InternalMyDsl.g:2108:3: () otherlv_1= '[' ( ( (lv_Objective_2_0= ruleObjective ) ) (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )* )? (otherlv_5= 'layer:' ( (lv_Layer_6_0= ruleLayer ) ) )? otherlv_7= ']'
            {
            // InternalMyDsl.g:2108:3: ()
            // InternalMyDsl.g:2109:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAssumptionAccess().getAssumptionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getAssumptionAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalMyDsl.g:2119:3: ( ( (lv_Objective_2_0= ruleObjective ) ) (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=47 && LA63_0<=50)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMyDsl.g:2120:4: ( (lv_Objective_2_0= ruleObjective ) ) (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )*
                    {
                    // InternalMyDsl.g:2120:4: ( (lv_Objective_2_0= ruleObjective ) )
                    // InternalMyDsl.g:2121:5: (lv_Objective_2_0= ruleObjective )
                    {
                    // InternalMyDsl.g:2121:5: (lv_Objective_2_0= ruleObjective )
                    // InternalMyDsl.g:2122:6: lv_Objective_2_0= ruleObjective
                    {

                    						newCompositeNode(grammarAccess.getAssumptionAccess().getObjectiveObjectiveEnumRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_48);
                    lv_Objective_2_0=ruleObjective();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssumptionRule());
                    						}
                    						add(
                    							current,
                    							"Objective",
                    							lv_Objective_2_0,
                    							"org.xtext.example.mydsl.MyDsl.Objective");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2139:4: (otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==14) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalMyDsl.g:2140:5: otherlv_3= ',' ( (lv_Objective_4_0= ruleObjective ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FOLLOW_49); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getAssumptionAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalMyDsl.g:2144:5: ( (lv_Objective_4_0= ruleObjective ) )
                    	    // InternalMyDsl.g:2145:6: (lv_Objective_4_0= ruleObjective )
                    	    {
                    	    // InternalMyDsl.g:2145:6: (lv_Objective_4_0= ruleObjective )
                    	    // InternalMyDsl.g:2146:7: lv_Objective_4_0= ruleObjective
                    	    {

                    	    							newCompositeNode(grammarAccess.getAssumptionAccess().getObjectiveObjectiveEnumRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_48);
                    	    lv_Objective_4_0=ruleObjective();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAssumptionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"Objective",
                    	    								lv_Objective_4_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Objective");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:2165:3: (otherlv_5= 'layer:' ( (lv_Layer_6_0= ruleLayer ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==40) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalMyDsl.g:2166:4: otherlv_5= 'layer:' ( (lv_Layer_6_0= ruleLayer ) )
                    {
                    otherlv_5=(Token)match(input,40,FOLLOW_50); 

                    				newLeafNode(otherlv_5, grammarAccess.getAssumptionAccess().getLayerKeyword_3_0());
                    			
                    // InternalMyDsl.g:2170:4: ( (lv_Layer_6_0= ruleLayer ) )
                    // InternalMyDsl.g:2171:5: (lv_Layer_6_0= ruleLayer )
                    {
                    // InternalMyDsl.g:2171:5: (lv_Layer_6_0= ruleLayer )
                    // InternalMyDsl.g:2172:6: lv_Layer_6_0= ruleLayer
                    {

                    						newCompositeNode(grammarAccess.getAssumptionAccess().getLayerLayerEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_Layer_6_0=ruleLayer();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssumptionRule());
                    						}
                    						set(
                    							current,
                    							"Layer",
                    							lv_Layer_6_0,
                    							"org.xtext.example.mydsl.MyDsl.Layer");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAssumptionAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssumption"


    // $ANTLR start "entryRuleElement"
    // InternalMyDsl.g:2198:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalMyDsl.g:2198:48: (iv_ruleElement= ruleElement EOF )
            // InternalMyDsl.g:2199:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalMyDsl.g:2205:1: ruleElement returns [EObject current=null] : (this_Process_0= ruleProcess | this_ExternalEntity_1= ruleExternalEntity | this_Flow_2= ruleFlow | this_DataStore_3= ruleDataStore | this_TrustZone_4= ruleTrustZone ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Process_0 = null;

        EObject this_ExternalEntity_1 = null;

        EObject this_Flow_2 = null;

        EObject this_DataStore_3 = null;

        EObject this_TrustZone_4 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2211:2: ( (this_Process_0= ruleProcess | this_ExternalEntity_1= ruleExternalEntity | this_Flow_2= ruleFlow | this_DataStore_3= ruleDataStore | this_TrustZone_4= ruleTrustZone ) )
            // InternalMyDsl.g:2212:2: (this_Process_0= ruleProcess | this_ExternalEntity_1= ruleExternalEntity | this_Flow_2= ruleFlow | this_DataStore_3= ruleDataStore | this_TrustZone_4= ruleTrustZone )
            {
            // InternalMyDsl.g:2212:2: (this_Process_0= ruleProcess | this_ExternalEntity_1= ruleExternalEntity | this_Flow_2= ruleFlow | this_DataStore_3= ruleDataStore | this_TrustZone_4= ruleTrustZone )
            int alt65=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt65=1;
                }
                break;
            case 36:
                {
                alt65=2;
                }
                break;
            case RULE_STRING:
                {
                int LA65_3 = input.LA(2);

                if ( (LA65_3==12) ) {
                    int LA65_6 = input.LA(3);

                    if ( (LA65_6==15||LA65_6==19||LA65_6==21) ) {
                        alt65=5;
                    }
                    else if ( (LA65_6==13||LA65_6==18||(LA65_6>=26 && LA65_6<=27)||LA65_6==30||(LA65_6>=37 && LA65_6<=38)) ) {
                        alt65=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA65_4 = input.LA(2);

                if ( (LA65_4==12) ) {
                    int LA65_6 = input.LA(3);

                    if ( (LA65_6==15||LA65_6==19||LA65_6==21) ) {
                        alt65=5;
                    }
                    else if ( (LA65_6==13||LA65_6==18||(LA65_6>=26 && LA65_6<=27)||LA65_6==30||(LA65_6>=37 && LA65_6<=38)) ) {
                        alt65=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 4, input);

                    throw nvae;
                }
                }
                break;
            case 39:
                {
                alt65=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalMyDsl.g:2213:3: this_Process_0= ruleProcess
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getProcessParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Process_0=ruleProcess();

                    state._fsp--;


                    			current = this_Process_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2222:3: this_ExternalEntity_1= ruleExternalEntity
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getExternalEntityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExternalEntity_1=ruleExternalEntity();

                    state._fsp--;


                    			current = this_ExternalEntity_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2231:3: this_Flow_2= ruleFlow
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getFlowParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Flow_2=ruleFlow();

                    state._fsp--;


                    			current = this_Flow_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2240:3: this_DataStore_3= ruleDataStore
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getDataStoreParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataStore_3=ruleDataStore();

                    state._fsp--;


                    			current = this_DataStore_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2249:3: this_TrustZone_4= ruleTrustZone
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getTrustZoneParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrustZone_4=ruleTrustZone();

                    state._fsp--;


                    			current = this_TrustZone_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:2261:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:2261:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:2262:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:2268:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2274:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:2275:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:2275:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_STRING) ) {
                alt66=1;
            }
            else if ( (LA66_0==RULE_ID) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalMyDsl.g:2276:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2284:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEBoolean"
    // InternalMyDsl.g:2295:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalMyDsl.g:2295:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalMyDsl.g:2296:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalMyDsl.g:2302:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2308:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalMyDsl.g:2309:2: (kw= 'true' | kw= 'false' )
            {
            // InternalMyDsl.g:2309:2: (kw= 'true' | kw= 'false' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==41) ) {
                alt67=1;
            }
            else if ( (LA67_0==42) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalMyDsl.g:2310:3: kw= 'true'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2316:3: kw= 'false'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleEInt"
    // InternalMyDsl.g:2325:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalMyDsl.g:2325:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalMyDsl.g:2326:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalMyDsl.g:2332:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2338:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:2339:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:2339:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:2340:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:2340:3: (kw= '-' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==43) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalMyDsl.g:2341:4: kw= '-'
                    {
                    kw=(Token)match(input,43,FOLLOW_51); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "rulePriority"
    // InternalMyDsl.g:2358:1: rulePriority returns [Enumerator current=null] : ( (enumLiteral_0= 'H' ) | (enumLiteral_1= 'M' ) | (enumLiteral_2= 'L' ) ) ;
    public final Enumerator rulePriority() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2364:2: ( ( (enumLiteral_0= 'H' ) | (enumLiteral_1= 'M' ) | (enumLiteral_2= 'L' ) ) )
            // InternalMyDsl.g:2365:2: ( (enumLiteral_0= 'H' ) | (enumLiteral_1= 'M' ) | (enumLiteral_2= 'L' ) )
            {
            // InternalMyDsl.g:2365:2: ( (enumLiteral_0= 'H' ) | (enumLiteral_1= 'M' ) | (enumLiteral_2= 'L' ) )
            int alt69=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt69=1;
                }
                break;
            case 45:
                {
                alt69=2;
                }
                break;
            case 46:
                {
                alt69=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalMyDsl.g:2366:3: (enumLiteral_0= 'H' )
                    {
                    // InternalMyDsl.g:2366:3: (enumLiteral_0= 'H' )
                    // InternalMyDsl.g:2367:4: enumLiteral_0= 'H'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getPriorityAccess().getHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPriorityAccess().getHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2374:3: (enumLiteral_1= 'M' )
                    {
                    // InternalMyDsl.g:2374:3: (enumLiteral_1= 'M' )
                    // InternalMyDsl.g:2375:4: enumLiteral_1= 'M'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getPriorityAccess().getMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPriorityAccess().getMEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2382:3: (enumLiteral_2= 'L' )
                    {
                    // InternalMyDsl.g:2382:3: (enumLiteral_2= 'L' )
                    // InternalMyDsl.g:2383:4: enumLiteral_2= 'L'
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getPriorityAccess().getLEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPriorityAccess().getLEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePriority"


    // $ANTLR start "ruleObjective"
    // InternalMyDsl.g:2393:1: ruleObjective returns [Enumerator current=null] : ( (enumLiteral_0= 'I' ) | (enumLiteral_1= 'C' ) | (enumLiteral_2= 'Av' ) | (enumLiteral_3= 'Ac' ) ) ;
    public final Enumerator ruleObjective() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2399:2: ( ( (enumLiteral_0= 'I' ) | (enumLiteral_1= 'C' ) | (enumLiteral_2= 'Av' ) | (enumLiteral_3= 'Ac' ) ) )
            // InternalMyDsl.g:2400:2: ( (enumLiteral_0= 'I' ) | (enumLiteral_1= 'C' ) | (enumLiteral_2= 'Av' ) | (enumLiteral_3= 'Ac' ) )
            {
            // InternalMyDsl.g:2400:2: ( (enumLiteral_0= 'I' ) | (enumLiteral_1= 'C' ) | (enumLiteral_2= 'Av' ) | (enumLiteral_3= 'Ac' ) )
            int alt70=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt70=1;
                }
                break;
            case 48:
                {
                alt70=2;
                }
                break;
            case 49:
                {
                alt70=3;
                }
                break;
            case 50:
                {
                alt70=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalMyDsl.g:2401:3: (enumLiteral_0= 'I' )
                    {
                    // InternalMyDsl.g:2401:3: (enumLiteral_0= 'I' )
                    // InternalMyDsl.g:2402:4: enumLiteral_0= 'I'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getObjectiveAccess().getIntegrityEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getObjectiveAccess().getIntegrityEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2409:3: (enumLiteral_1= 'C' )
                    {
                    // InternalMyDsl.g:2409:3: (enumLiteral_1= 'C' )
                    // InternalMyDsl.g:2410:4: enumLiteral_1= 'C'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getObjectiveAccess().getConfidentialityEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getObjectiveAccess().getConfidentialityEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2417:3: (enumLiteral_2= 'Av' )
                    {
                    // InternalMyDsl.g:2417:3: (enumLiteral_2= 'Av' )
                    // InternalMyDsl.g:2418:4: enumLiteral_2= 'Av'
                    {
                    enumLiteral_2=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getObjectiveAccess().getAvailabilityEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getObjectiveAccess().getAvailabilityEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2425:3: (enumLiteral_3= 'Ac' )
                    {
                    // InternalMyDsl.g:2425:3: (enumLiteral_3= 'Ac' )
                    // InternalMyDsl.g:2426:4: enumLiteral_3= 'Ac'
                    {
                    enumLiteral_3=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getObjectiveAccess().getAccountabilityEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getObjectiveAccess().getAccountabilityEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjective"


    // $ANTLR start "ruleLayer"
    // InternalMyDsl.g:2436:1: ruleLayer returns [Enumerator current=null] : ( (enumLiteral_0= 'Transport' ) | (enumLiteral_1= 'Architectural' ) | (enumLiteral_2= 'Application' ) ) ;
    public final Enumerator ruleLayer() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2442:2: ( ( (enumLiteral_0= 'Transport' ) | (enumLiteral_1= 'Architectural' ) | (enumLiteral_2= 'Application' ) ) )
            // InternalMyDsl.g:2443:2: ( (enumLiteral_0= 'Transport' ) | (enumLiteral_1= 'Architectural' ) | (enumLiteral_2= 'Application' ) )
            {
            // InternalMyDsl.g:2443:2: ( (enumLiteral_0= 'Transport' ) | (enumLiteral_1= 'Architectural' ) | (enumLiteral_2= 'Application' ) )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt71=1;
                }
                break;
            case 52:
                {
                alt71=2;
                }
                break;
            case 53:
                {
                alt71=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // InternalMyDsl.g:2444:3: (enumLiteral_0= 'Transport' )
                    {
                    // InternalMyDsl.g:2444:3: (enumLiteral_0= 'Transport' )
                    // InternalMyDsl.g:2445:4: enumLiteral_0= 'Transport'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getLayerAccess().getTransportEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLayerAccess().getTransportEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2452:3: (enumLiteral_1= 'Architectural' )
                    {
                    // InternalMyDsl.g:2452:3: (enumLiteral_1= 'Architectural' )
                    // InternalMyDsl.g:2453:4: enumLiteral_1= 'Architectural'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getLayerAccess().getArchitecturalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLayerAccess().getArchitecturalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2460:3: (enumLiteral_2= 'Application' )
                    {
                    // InternalMyDsl.g:2460:3: (enumLiteral_2= 'Application' )
                    // InternalMyDsl.g:2461:4: enumLiteral_2= 'Application'
                    {
                    enumLiteral_2=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getLayerAccess().getApplicationEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLayerAccess().getApplicationEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayer"


    // $ANTLR start "ruleResponsibilityType"
    // InternalMyDsl.g:2471:1: ruleResponsibilityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Store' ) | (enumLiteral_1= 'Comparator' ) | (enumLiteral_2= 'Discarder' ) | (enumLiteral_3= 'Joiner' ) | (enumLiteral_4= 'Copier' ) | (enumLiteral_5= 'Splitter' ) | (enumLiteral_6= 'Forward' ) | (enumLiteral_7= 'EncryptOrHash' ) | (enumLiteral_8= 'Decrypt' ) | (enumLiteral_9= 'Authenticator' ) | (enumLiteral_10= 'Authoriser' ) | (enumLiteral_11= 'Verifier' ) | (enumLiteral_12= 'User' ) ) ;
    public final Enumerator ruleResponsibilityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2477:2: ( ( (enumLiteral_0= 'Store' ) | (enumLiteral_1= 'Comparator' ) | (enumLiteral_2= 'Discarder' ) | (enumLiteral_3= 'Joiner' ) | (enumLiteral_4= 'Copier' ) | (enumLiteral_5= 'Splitter' ) | (enumLiteral_6= 'Forward' ) | (enumLiteral_7= 'EncryptOrHash' ) | (enumLiteral_8= 'Decrypt' ) | (enumLiteral_9= 'Authenticator' ) | (enumLiteral_10= 'Authoriser' ) | (enumLiteral_11= 'Verifier' ) | (enumLiteral_12= 'User' ) ) )
            // InternalMyDsl.g:2478:2: ( (enumLiteral_0= 'Store' ) | (enumLiteral_1= 'Comparator' ) | (enumLiteral_2= 'Discarder' ) | (enumLiteral_3= 'Joiner' ) | (enumLiteral_4= 'Copier' ) | (enumLiteral_5= 'Splitter' ) | (enumLiteral_6= 'Forward' ) | (enumLiteral_7= 'EncryptOrHash' ) | (enumLiteral_8= 'Decrypt' ) | (enumLiteral_9= 'Authenticator' ) | (enumLiteral_10= 'Authoriser' ) | (enumLiteral_11= 'Verifier' ) | (enumLiteral_12= 'User' ) )
            {
            // InternalMyDsl.g:2478:2: ( (enumLiteral_0= 'Store' ) | (enumLiteral_1= 'Comparator' ) | (enumLiteral_2= 'Discarder' ) | (enumLiteral_3= 'Joiner' ) | (enumLiteral_4= 'Copier' ) | (enumLiteral_5= 'Splitter' ) | (enumLiteral_6= 'Forward' ) | (enumLiteral_7= 'EncryptOrHash' ) | (enumLiteral_8= 'Decrypt' ) | (enumLiteral_9= 'Authenticator' ) | (enumLiteral_10= 'Authoriser' ) | (enumLiteral_11= 'Verifier' ) | (enumLiteral_12= 'User' ) )
            int alt72=13;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt72=1;
                }
                break;
            case 55:
                {
                alt72=2;
                }
                break;
            case 56:
                {
                alt72=3;
                }
                break;
            case 57:
                {
                alt72=4;
                }
                break;
            case 58:
                {
                alt72=5;
                }
                break;
            case 59:
                {
                alt72=6;
                }
                break;
            case 60:
                {
                alt72=7;
                }
                break;
            case 61:
                {
                alt72=8;
                }
                break;
            case 62:
                {
                alt72=9;
                }
                break;
            case 63:
                {
                alt72=10;
                }
                break;
            case 64:
                {
                alt72=11;
                }
                break;
            case 65:
                {
                alt72=12;
                }
                break;
            case 66:
                {
                alt72=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalMyDsl.g:2479:3: (enumLiteral_0= 'Store' )
                    {
                    // InternalMyDsl.g:2479:3: (enumLiteral_0= 'Store' )
                    // InternalMyDsl.g:2480:4: enumLiteral_0= 'Store'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getStoreEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getResponsibilityTypeAccess().getStoreEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2487:3: (enumLiteral_1= 'Comparator' )
                    {
                    // InternalMyDsl.g:2487:3: (enumLiteral_1= 'Comparator' )
                    // InternalMyDsl.g:2488:4: enumLiteral_1= 'Comparator'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getComparatorEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getResponsibilityTypeAccess().getComparatorEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2495:3: (enumLiteral_2= 'Discarder' )
                    {
                    // InternalMyDsl.g:2495:3: (enumLiteral_2= 'Discarder' )
                    // InternalMyDsl.g:2496:4: enumLiteral_2= 'Discarder'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getDiscarderEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getResponsibilityTypeAccess().getDiscarderEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2503:3: (enumLiteral_3= 'Joiner' )
                    {
                    // InternalMyDsl.g:2503:3: (enumLiteral_3= 'Joiner' )
                    // InternalMyDsl.g:2504:4: enumLiteral_3= 'Joiner'
                    {
                    enumLiteral_3=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getJoinerEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getResponsibilityTypeAccess().getJoinerEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2511:3: (enumLiteral_4= 'Copier' )
                    {
                    // InternalMyDsl.g:2511:3: (enumLiteral_4= 'Copier' )
                    // InternalMyDsl.g:2512:4: enumLiteral_4= 'Copier'
                    {
                    enumLiteral_4=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getCopierEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getResponsibilityTypeAccess().getCopierEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2519:3: (enumLiteral_5= 'Splitter' )
                    {
                    // InternalMyDsl.g:2519:3: (enumLiteral_5= 'Splitter' )
                    // InternalMyDsl.g:2520:4: enumLiteral_5= 'Splitter'
                    {
                    enumLiteral_5=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getSplitterEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getResponsibilityTypeAccess().getSplitterEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2527:3: (enumLiteral_6= 'Forward' )
                    {
                    // InternalMyDsl.g:2527:3: (enumLiteral_6= 'Forward' )
                    // InternalMyDsl.g:2528:4: enumLiteral_6= 'Forward'
                    {
                    enumLiteral_6=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getForwardEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getResponsibilityTypeAccess().getForwardEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2535:3: (enumLiteral_7= 'EncryptOrHash' )
                    {
                    // InternalMyDsl.g:2535:3: (enumLiteral_7= 'EncryptOrHash' )
                    // InternalMyDsl.g:2536:4: enumLiteral_7= 'EncryptOrHash'
                    {
                    enumLiteral_7=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getEncryptOrHashEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getResponsibilityTypeAccess().getEncryptOrHashEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:2543:3: (enumLiteral_8= 'Decrypt' )
                    {
                    // InternalMyDsl.g:2543:3: (enumLiteral_8= 'Decrypt' )
                    // InternalMyDsl.g:2544:4: enumLiteral_8= 'Decrypt'
                    {
                    enumLiteral_8=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getDecryptEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getResponsibilityTypeAccess().getDecryptEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:2551:3: (enumLiteral_9= 'Authenticator' )
                    {
                    // InternalMyDsl.g:2551:3: (enumLiteral_9= 'Authenticator' )
                    // InternalMyDsl.g:2552:4: enumLiteral_9= 'Authenticator'
                    {
                    enumLiteral_9=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getAuthenticatorEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getResponsibilityTypeAccess().getAuthenticatorEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:2559:3: (enumLiteral_10= 'Authoriser' )
                    {
                    // InternalMyDsl.g:2559:3: (enumLiteral_10= 'Authoriser' )
                    // InternalMyDsl.g:2560:4: enumLiteral_10= 'Authoriser'
                    {
                    enumLiteral_10=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getAuthoriserEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getResponsibilityTypeAccess().getAuthoriserEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:2567:3: (enumLiteral_11= 'Verifier' )
                    {
                    // InternalMyDsl.g:2567:3: (enumLiteral_11= 'Verifier' )
                    // InternalMyDsl.g:2568:4: enumLiteral_11= 'Verifier'
                    {
                    enumLiteral_11=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getVerifierEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getResponsibilityTypeAccess().getVerifierEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalMyDsl.g:2575:3: (enumLiteral_12= 'User' )
                    {
                    // InternalMyDsl.g:2575:3: (enumLiteral_12= 'User' )
                    // InternalMyDsl.g:2576:4: enumLiteral_12= 'User'
                    {
                    enumLiteral_12=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getResponsibilityTypeAccess().getUserEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getResponsibilityTypeAccess().getUserEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResponsibilityType"


    // $ANTLR start "ruleChannel"
    // InternalMyDsl.g:2586:1: ruleChannel returns [Enumerator current=null] : ( (enumLiteral_0= 'VLAN' ) | (enumLiteral_1= 'ETH' ) | (enumLiteral_2= 'WiFi' ) ) ;
    public final Enumerator ruleChannel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2592:2: ( ( (enumLiteral_0= 'VLAN' ) | (enumLiteral_1= 'ETH' ) | (enumLiteral_2= 'WiFi' ) ) )
            // InternalMyDsl.g:2593:2: ( (enumLiteral_0= 'VLAN' ) | (enumLiteral_1= 'ETH' ) | (enumLiteral_2= 'WiFi' ) )
            {
            // InternalMyDsl.g:2593:2: ( (enumLiteral_0= 'VLAN' ) | (enumLiteral_1= 'ETH' ) | (enumLiteral_2= 'WiFi' ) )
            int alt73=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt73=1;
                }
                break;
            case 68:
                {
                alt73=2;
                }
                break;
            case 69:
                {
                alt73=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalMyDsl.g:2594:3: (enumLiteral_0= 'VLAN' )
                    {
                    // InternalMyDsl.g:2594:3: (enumLiteral_0= 'VLAN' )
                    // InternalMyDsl.g:2595:4: enumLiteral_0= 'VLAN'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getChannelAccess().getVLANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getChannelAccess().getVLANEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2602:3: (enumLiteral_1= 'ETH' )
                    {
                    // InternalMyDsl.g:2602:3: (enumLiteral_1= 'ETH' )
                    // InternalMyDsl.g:2603:4: enumLiteral_1= 'ETH'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getChannelAccess().getETHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getChannelAccess().getETHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2610:3: (enumLiteral_2= 'WiFi' )
                    {
                    // InternalMyDsl.g:2610:3: (enumLiteral_2= 'WiFi' )
                    // InternalMyDsl.g:2611:4: enumLiteral_2= 'WiFi'
                    {
                    enumLiteral_2=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getChannelAccess().getWiFiEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getChannelAccess().getWiFiEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChannel"


    // $ANTLR start "ruleAssetType"
    // InternalMyDsl.g:2621:1: ruleAssetType returns [Enumerator current=null] : ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Number' ) | (enumLiteral_2= 'Object' ) | (enumLiteral_3= 'Vector' ) ) ;
    public final Enumerator ruleAssetType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2627:2: ( ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Number' ) | (enumLiteral_2= 'Object' ) | (enumLiteral_3= 'Vector' ) ) )
            // InternalMyDsl.g:2628:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Number' ) | (enumLiteral_2= 'Object' ) | (enumLiteral_3= 'Vector' ) )
            {
            // InternalMyDsl.g:2628:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Number' ) | (enumLiteral_2= 'Object' ) | (enumLiteral_3= 'Vector' ) )
            int alt74=4;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt74=1;
                }
                break;
            case 71:
                {
                alt74=2;
                }
                break;
            case 72:
                {
                alt74=3;
                }
                break;
            case 73:
                {
                alt74=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalMyDsl.g:2629:3: (enumLiteral_0= 'String' )
                    {
                    // InternalMyDsl.g:2629:3: (enumLiteral_0= 'String' )
                    // InternalMyDsl.g:2630:4: enumLiteral_0= 'String'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getAssetTypeAccess().getStringEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAssetTypeAccess().getStringEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2637:3: (enumLiteral_1= 'Number' )
                    {
                    // InternalMyDsl.g:2637:3: (enumLiteral_1= 'Number' )
                    // InternalMyDsl.g:2638:4: enumLiteral_1= 'Number'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getAssetTypeAccess().getNumberEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAssetTypeAccess().getNumberEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2645:3: (enumLiteral_2= 'Object' )
                    {
                    // InternalMyDsl.g:2645:3: (enumLiteral_2= 'Object' )
                    // InternalMyDsl.g:2646:4: enumLiteral_2= 'Object'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getAssetTypeAccess().getObjectEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAssetTypeAccess().getObjectEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2653:3: (enumLiteral_3= 'Vector' )
                    {
                    // InternalMyDsl.g:2653:3: (enumLiteral_3= 'Vector' )
                    // InternalMyDsl.g:2654:4: enumLiteral_3= 'Vector'
                    {
                    enumLiteral_3=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getAssetTypeAccess().getVectorEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAssetTypeAccess().getVectorEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssetType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000005A000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000005C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000009010000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000054000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000002C8000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000024C000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000244000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000080000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003C0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000006E0042000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000006C0046000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000006C0044000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000680044000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000600044000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400044000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0xFFC0000000044030L,0x0000000000000007L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0xFFC0000000004030L,0x0000000000000007L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000044030L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000006C0042000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x000000604C042000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000000404C042000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x000000404C044000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000004048040000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000004040044000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000040040000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0007F00000040000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0007800000040000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0007810000040000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000010000044000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0007800000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0038000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000040L});

}