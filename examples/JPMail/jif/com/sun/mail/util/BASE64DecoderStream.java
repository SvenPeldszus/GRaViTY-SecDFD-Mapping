package com.sun.mail.util;

import java.io.*;

public class BASE64DecoderStream extends FilterInputStream {
    private static int __JIF_SIG_OF_JAVA_CLASS$20030619 = 0;
    
    public BASE64DecoderStream(final InputStream in) { super(in); }
    
    public BASE64DecoderStream(final InputStream in,
                               final boolean ignoreErrors) {
        super(in);
    }
    
    native public int read() throws IOException;
    
    native public int read(final byte[] buf, final int off, final int len)
          throws IOException;
    
    native public boolean markSupported();
    
    native public int available() throws IOException;
    
    native public static byte[] decode(final byte[] inbuf);
    
    final public static String jlc$CompilerVersion$jif = "2.0.1";
    final public static long jlc$SourceLastModified$jif = 1140055276000L;
    final public static String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1ae3AVVxk/9yYkJATDIzRQ87iEhJIGklAeQsO0JCGhCbcl" +
       "JYHB9HHdu/fcZMve\n3WX3XLhQqS1YYKq1QxFKH+J0rLZTHRVtqyIqHdR2il" +
       "bR8VEttVan9kUdbTutMzr1+87u3t27dzeP\nacIf59xzz37nnO/xO9/3nbP7" +
       "jQtkiqGT6lukZDPbpVGjuVdK9gm6QRN9qrxrALpi4m/2H3/4Z6te\neyZMCq" +
       "KkREizYVWX2C5GZkRvEXYILWkmyS1RyWBtUTJDUgwmKEwSGE1062qKkflRDa" +
       "YaklXWQjOs\nRRN0IdXCF2vp65QFw4BhRbzX2E5uI6GMTi6zRzTDiOZbZIs3" +
       "kzE+xuTs7rcPFLeEN4cKSPkgKZeU\nfiYwSexUFQbjBklZiqbiVDfaEwmaGC" +
       "QzFUoT/VSXBFnaDYSqMkhmGdKQIrC0To1N1FDlHUg4y0hr\nVOdr2p1RUiaq" +
       "IJqeFpmqm4wC20mJygn735SkLAwZjFziCGyK2Y39IGWpBIzpSUGk9pDCbZKS" +
       "YKTW\nOyIrY/0GIIChxSkKas8uVagI0EFmmQaQBWWopZ/pkjIEpFPUNKzCyK" +
       "WBkwLRVE0QtwlDNMbIXC9d\nn/kIqEq4InAII3O8ZHwmMNZ8f2O5zHRPquC+" +
       "/adfrwxz1hNUlFGMYhjb4D92E01SnSoiNcdfvae4\n5LVX1neECYExVf5jTN" +
       "KXY6fn/Hr3f/aapHXBpBvjt1CRxcTzJ+sulLYv3lOAvE3VVENCYORoheO7\n" +
       "z3rSltFgw1ySnRgfNtsPT2/6+Sdvf5y+GSZFPaRIVOV0SukhJVRJdFrtYmhH" +
       "JYX2kEIZfkAdSUmm\nqI4iaGsCG+btjEYIKYYSgVKOhZHKjvb+rpXL11FRTV" +
       "AdzE2FVDNsXEaWAoiXGLrYIqqpFiOttKQE\n4JizHTAmg6uU7wyFQJYFAZtN" +
       "Bpxeo8owLia21g794EfdLzaEs+Cz2GSkARZthkWbcVFTHT6LklCI\nL1aZqz" +
       "i0RAJdx1vfaZvxhSXGU+BjBkmJlEqlmRCXQT9lgiyrO2kixjgKZ7oQbzuPsj" +
       "gAFrAfk2Ei\n04VoZIfb+hYinQ3cw72USG9deR05UtP1AMIF7VqBs5usgZW2" +
       "mbyVNfbf1Pupg3UFSLSzEKwRBtK6\nHJ/pM3dMfOrhU+z8mYZ3wmTKIKmQjH" +
       "U0KaRltomCv1GiQpzKg2R2thucl854b5RMM52NAA7D3vLT\ndGcYgCEKy1sb" +
       "UcauFv4AnYyRnQdH1sI2aArYoX48v3Wq7dVo6ysD5gZqDMCGroo0AU7TGbdv" +
       "/T9j\nfz9cMwiygt8A9hkwj26oxus3cjZ3m+UQGKnLc0PeRdpsF4tyFYJGkq" +
       "qeEmScxlZSKRvW1Z1OD8f5\ndN6eAXabBmU5lFlYsJNXs83dgFU9YsADG+69" +
       "3+k5cM2rZxfdFHY7+nJX/OunzHQNMx0IDeiUQv/5\nY32Hj1w4cAPHjwmgEI" +
       "OQl47LkpjhzFWGAK+zPQujGM1zK754tPGhP9gAne3M3q7rwi7EZ+aO31Tf\n" +
       "/4zwJXBh4FYMaTfl7iNkroSbzoEqxwVNmM7y3LRlByMrkhVhEgabcRhBiOVb" +
       "qBacIY6w/5dwHZVl\nNVkLpdVHk7Dapc5qfEpgdIgvGxPpd4ylYsPr9/MFS9" +
       "MaBJcONa0krBXDOyRGqrw42CJk4YnhptI7\nvTX350/sPLfike0387mnJagh" +
       "6pKGTtlyrkVM7QXdYbDlW0cXFEOGLMXcOAP8YVdG09s8mEFJl/lI\nykgHMp" +
       "pSdW1YEiOcl4iajLBhGjGBGRH0oXSKKiwiKZFFcRSUJiJCXN1BI/FdkVujex" +
       "pBXQ1cHpub\n5k5BUVTm4SkmvrHx7dO7NfqsuS1rc8fkUb/63JPbbt76kws2" +
       "aqq8OuvDdMtS3Pd2Vvzss9pLCzm0\np/NEzNY3I/NcfqbP/chU08qsmpYEAI" +
       "KRtaZq+MQUMpNIFNUkovOOjCl2GHkCc07cAt/x1aH3//f0\n4+/ZAs9zBM7h" +
       "OiY+Uzw09cpHVr5bwDHv8lNzXZKiQ3clS1aWVhOkCzNJywSGUheCY2K1/OSK" +
       "4585\n8fswKR4kM7ifh3x5iyCn0VcMQpJodFqdYI6c57kJn5nBtLkyqhUeB+" +
       "kEamgjK85OdvA9H8oiO8tw\nGY4QDRu9nHAhrxtN51XAYBlJEfiaTeDJDJ52" +
       "g6lDUSMwp+vTpRQkSTusnO7Q3hc2FGSOtoddafCC\n/BDgGmNpmfshDR3NfI" +
       "+/zKf+adP8b9y26aW4uWtm5eYeXUo69Y9dZ+hla+7+q09eM0W2Q2g5l5pk\n" +
       "cjcSYCSqioLsWLZiT8cnHj1PT5gxQnZH4ACdeCZY0PDJh19P/WQxsosjr8Fq" +
       "dSZkWmIw3xIhbF8H\nig/DsQvbS7FaxgevzTvX9afjBnOl5RVrtq/eLG283i" +
       "/U891qDfWOO9r45o6m1r1f4p62MC4YXGnF\nILOBlIxEgk98fC7TiKVZCNow" +
       "LMECYbVH0dLMneDWWgnujYj+GyX1Rg8Fny/O56tgVoyU1GYXFc/t\n8pQRE2" +
       "8arjx+96HOF7nNyjn/3C32m5IszHUK1qD6/lw63PqRkdUXE4/Xvnb82NGT2/" +
       "hBw9aUO4O4\nVtDyMohrBGMY+qcU/+npM5d86hw4rW5SKqtColvgaRuoaxiO" +
       "rsOQpme0q9ciTEnZzqmWTkNcI11Z\nPddBabT1jJ088FJ7q6sjbPVsvuLZ7k" +
       "h7vcb1vwWrpL1X8M9V2ZWboCyepOiAM3VyV5XBLVrvZ2av\nxbpLPmz77bTz" +
       "13KzF7FhyahvxYO7n7XBKDg738urONDsnA3rZt5uQaEt0UMhV0rnMNNuGBBm" +
       "IB9Z\nU3nwlV9VPz9gxirvaJDg495o3atKihWslw3++W9fvv6+DZzxUlCQpi" +
       "rUOiRcZoZkDbTa1qEypqbs\nfMTUMYROsBtdzLtSqsEipkmtx3D2NSQ4c+GR" +
       "MDfcZtd3h9yzv7vn+QsfnNxnO6s1PJfJIhcOvDKE\nJ5DXqN+spNSElJTwRA" +
       "cx7vbqe8/d8+Dtm02/s3j0MU7/vA5y+9mb36/h4odEbrLsBnLIzH1U6T3M\n" +
       "4W6C9f8o/2HwyPnLa8z1PbsNnp9cd+eRo9//3nLzvFeGm8naWsQ3vx1QNcs6" +
       "f71j2TcHlLYBWycr\nsWoAe6wGmlGNoUuQnlKvNXCKNl7X5JxjroVyCRa/c8" +
       "wRrBb5wjRsnWB5uMjL570zcoLlecmwl2xi\nkmFHVMdzLAlgbGI9B29uxeoh" +
       "O9x+BasbPKH1Aa7iL/OOGFYi7/gad328d5jXqXxf7HjYfLc4ucJl\nTCt+Gq" +
       "tHsXqQ8+xBwAooV4+OACSL+rIcHTsChhRVp126rurGeLCwJoDFycLCCRsL37" +
       "ewUObm3EHF\ntzgInrCDIf8dYKQ4rqoyFfgB9NtY/XCMgQPrfXmP8f9+3nsI" +
       "q6O847CpKGtivPWq8l5f4BW1nWOm\n4re+d+Z4acSJPVXZW4Lc3DZnWEwMP/" +
       "bygca55S9AzjdIPjYsGD0KpNp4kU71MSa7nhnffSIWunFF\n9T7uyp2DGE5S" +
       "Z2a/Ofnhaut3hsvulnWey89bwqB9y59i70aASCQW6+3pjvX3rI9t7I71tm9p" +
       "j3VG\n2/v7669obV3WunLpatOemkvPLlsWSAq/BynnxtmfcflX4lizygni1d" +
       "7Lx5wb/QNb/1W2X/jpTXag\n2Mwgk1O1JTLdQWXHlt5JruUvAWwdPlw0K1EY" +
       "XTXXa8z8Nzq542Ji0Vaj9dSZD/874ReTHAK+d5AL\n/UHh5ezDY6de/vqi1z" +
       "9vni1c59dSc5WBnFPs/CxEMLGshnIpFr+I+BdfkBQpAh4YsbNp5M3p+9C+\n" +
       "Ysv1pE0WXL28eLzZygCySfBmOYeijV0ZkfKbMViqEMgTHv5Rl3NH539OANnE" +
       "8o/VuRAZ0TPyjjux\netPaCAd5fRevv5CTwvEp3vDKgtCJXBxbnM/RMx57P4" +
       "7FB7NWPMjFLLb/NgJeC8xzm8ekjVYW5V3K\nE9wbLVh6yRjpGnNwj6eTPjF9" +
       "DXi3q9xRHWNYqNQdw7JxF7pNzx7iOxfibgFMagS+aeQX4ebVRPXe\n078dLj" +
       "343TC//rKvJkq8b2rzX8TmvF/lXE1DBqZmslHebuenpvnamnDQuCJRYXwXo5" +
       "rG9VOCnaGZ\n+ZxiXYHVXKD0YGEVlKtGxwKSdfhK1zlmLKhJPywE5ndtAZxN" +
       "Un4Xitg4u8zGGTDsqLGGq3EB90DY\nquUtjzbXQekdXZtIdt1H1KZMx3VyWh" +
       "/A2WRpc4mtzeW2NoFhR5tNXJutWW0u5q3xxNWtUJJBqnbk\nFgPIJj4uvT1C" +
       "AK0KYvTOnADqRzZaCAt7BMbjUOXFEDhkZl1jDsehNWMKx6E2r2bsdxIfVTN4" +
       "4bng\nImnGJ7hfbhm4yrU01jy4+1znjxrcR0xG7YeMTE8J+rb+tKapOqNB4P" +
       "Qy5lHdvACyid9FPxzXuTd0\nQ17OkKv0Oiudq/ZTemqile7vqZZYwczLh0fH" +
       "qwLIJsdTlcABQJIF+04xP98fhds5AWSTke+PjAjH\nwWTG5mB2Zhz8KCPgB0" +
       "F/BZQaLH74uSsfPwUOfrDaOB6c4FXqlT7reZIHJOvwIWNk/ThuXceTmB/2\n" +
       "T8wP2yH+GHZBiJ/Cp3Wy0EOuLPSQF0CfCJB24r3xXCs/vjeIM6wfsilHc6dF" +
       "Cb6Ux3aIlaYg2zmh\nrC6AbLyhDMNY/UVR3r0ZU2s5kkaCJOUKPRF0nr44ph" +
       "5fAPlczsUpI7N9FsHXR7VBHyGbH86Ki417\nv7b9ka9UmWdN+xuMqVEyNZmW" +
       "ZfenF652kabTpMQ5mGp+iMEvHEM/YmRmnviQXeIPN8cpk+40ww+R\nHTogwR" +
       "83yRlGii0SyMGhdj/8OXTBQ2w+Y0IwljVasWWw6VgYmdMN01M972V8g/21KX" +
       "/zJqktvnR8\ntWf53BWMzLNvn/JoOUXgSxPe77zAxtdPC20OcYHnsDprvcAO" +
       "/TrAO1/n8s741hpb/TjgF/5vq/Gw\n1kXyP4mZtNcyoeddF/iuq1tNlxRR0g" +
       "QZv20xWz/+07O9bzz90MLAt8eVuTe/afMb+5j4lnbz+j9v\n+svj5lvPBYGf" +
       "KzgjLjW2T9+6oDfJ72KngJC7d+N6xVFSbEYXvnwo7xNw92z2XNLLv0/ete/v" +
       "5faF\nN1qPzDQDqyN6TfA82N4yve2PG06efMx74U1c2qsM+PJr+aL3ij/45b" +
       "/X5uot5HxG05v5P9lb5/sN\nMQAA");
    final public static String jlc$CompilerVersion$jl = "2.0.0";
    final public static long jlc$SourceLastModified$jl = 1140055276000L;
    final public static String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAK16a8zs2nXQnHPvPTd3cpPc3ObVcG8eNwlp6ub4PR5zkZDH" +
       "M/Z4xo8Zj8djG6KD\nn+P3e2yPoxb6UFJRSoE0oaBSCYH4AUECCkWgIkVqBT" +
       "/gBwIJhEQhVFWhogEh4Ef/EDzznXPP437n\nFiE+adv7815r7bXXa6/Za3/7" +
       "e6OXqnL0xTyLz8c4q++7XX0/jO/X59yt7m/MsnIdOjarShk+PLB/\n9r9+/W" +
       "Xw7v7OC6MPGaMPBemuNuvAprO0HvCM0auJm1huWVGO4zrG6MOp6zo7twzMOO" +
       "gHwCw1Rq9X\nwTE161PpVrJbZXFzAXy9OuVueZ3z0Ud+9KqdpVVdnuw6K6t6" +
       "9Bofmo0JnuogBvmgqt/mR/e8wI2d\nqhj92OgOP3rJi83jAPgx/tFiwCtFkL" +
       "l8H8DHwcBm6Zm2+wjlxShInXr06Wcx3lnx59cDwID6cuLW\nfvbOVC+m5vBh" +
       "9PoNS7GZHsFdXQbpcQB9KTsNs9SjTz6X6AD0vty0I/PoPqhHn3gWbnMzNEC9" +
       "chXL\nBaUeffRZsCulrhx99nbVPaG0n0te+Atf+87vfPzulXXHtePLMl4acL" +
       "9wO67sem7pprZ7g/9HfvTl\nV/7zb7Kzu6PRgPPG7Tg3oN998J2P/ov+937i" +
       "BvSt54NKVuja9QP7N/7RW98bUz/yoy9ceHtfnlXB\nxUyekspV45uHI293+W" +
       "CuH3uH8GXw/qPB78j/RP+Tf8P9L3dH97jRPTuLT0nKjV5xU4d+2H956PNB\n" +
       "6nKjF+PhNYjDC2L3Io4Xh35u1v613+Wj0ejloX1maB+6tHr08Rm1W0ywuWtn" +
       "jlsO6nbN5H4YePUI\nHkz6y1Vpg3aWgNUpBRNz4PjK9nNwusssH2jv3BnW8r" +
       "nnuF482Okyiwe8Bzb06eM//MfMv/vC3XeM\n7yGb9egLw6T3h0nvXya9Ecct" +
       "k47u3LlO9vGnBXfRhHNxpt/9u2+/9me+XP3K3dELxuiVIElOtWnF\ng3xeNe" +
       "M4a13nQX21wg8/YfFXCxus9FVrMNjB9h/EA6Grgwzia57U/kOLfOzO3NAzB/" +
       "v66kQcffNT\ni790MZeLXj9yoX7D2qCl6Ia3V7+0+8rqj//0Wy9cgNoXB23c" +
       "HUCB55j9uyd5YP/ur7792zz0m8qN\nVX7pOQIvM9t1hrj0GO8n2f/24Le+8S" +
       "nj7uilwRmHcFSbg9EMvv2pZ53xKY95+6GX1aO33uXbz07y\n9qO4dRHcXX70" +
       "fi8rEzO+kHkUbMa1X2bt4y9X43n/tf/BQRjvHxo2tNcv7fLxtcvjwzcmdnl8" +
       "5iLY\nZ3RxDYn/g/v68rf/2Q995e6T0fNDT4TZnVvf+NuHH+tFKV13+P4bv7" +
       "D5xje/9/U/elXKjVbu1KN7\n+cmKA7u7MvfRO4MR/MAzE1+Wcf8TH/n5b33p" +
       "F//NI63/wGPqVFma54vSux//l2/+xX9q/uUhLgy+\nWgW9e/XJOzczXem/Xj" +
       "/EDLL7XJqf6htTfzT55fnD1z4woIyuiKObwTeeEp4wtI9d2m3Cgy+Pz99K\n" +
       "8u6NLV7+Hbz/ebF0UwbJEJyah7H0z/3Ev12/0H2LuvvE9vO5d1vJEzg3W9CV" +
       "o3HeVU8G/FtmuEL/\nOvDZb/+Y/O+tG3t//WmfX6Sn5D+df8394h/+2f94Sz" +
       "x52cqy2DXT9xbjw9GLm7/xrGld9uRH5p1Y\nX/1fv/ZL48/cqPqC88krhRef" +
       "L7Cn8B/Y//PvPbjzx/A3f/LK6mMfvJD6VPfc6KmaT7j/m/Hfx3/p\nT/ydf3" +
       "139LIxeu2aVZhprZrx6WLJxpAXVPTDj/zoA0+NP73H32xaj937jWcV98S0zz" +
       "r2YykP/Qv0\npf/yM7782tDIh+/XnjDHO6P80mGugG9dn194GAoHjeVl0Jj1" +
       "wOu96pqOdfXoMw8erDjmwY5jH0jM\ngxWlUg9ontrtPo9AEApNYPJKA89v9D" +
       "itRy8MudHV6K8fZjccff/m738/bN8fpEFnST7smOVnWHfQ\nwjCrk3d3Bs9/" +
       "CbkP3b86y+bdTL4wjHtBal7zji9eHuuBx4+Hsf35R/TUIWscdvDPD5vjI+d+" +
       "7erc\nF8Hfv0munuDv8th21y3tg4/B+GzIwH7mt/7sP/+5z/2HwV5Wo5eaix" +
       "IHM3mClni6pKhf+/Y333z/\nz3/3Z66GOUSUV/Jv/d53L1SNy0MZ0rcLd7vs" +
       "VNoub1a1kDnBkG067zD4hOxejLNbmas/0i2xiqMe\n/fGw6aKUqnYRSJ71aE" +
       "Upc66Xt1MiWPgrjo1iyt1WErSiWZ+27HilL2fkcumcQM82hMYdowcN1Xh/\n" +
       "W+xgXV8X8LZj1ktgBZW8oSxltS7OXLF0ZCSILXmqLurBhFMy2juWcqqFvoSB" +
       "KXFCa4RwenczNm3O\nw8mu71EiTSWwk0gQTa0NEW7rKChYZRKfImO+sXKVDU" +
       "+qsyaPyWQri2RRdiXF5wGWgMgSBTFjUrtj\n92wIdLGO5EXQ6+pBQ2icNSK5" +
       "WWg6xx+i5LyD5fNhVu+V1Xx/bJP1ot2xCxiaIAOSF8tzUzejWDts\nQ6kay7" +
       "IIcY5GM0iTT/At02IzX7Z6DVngJ27CCkow6eVemQeSYRlchUb9AuhOSkWU9o" +
       "bh3YWI2evd\nJjquDXc/9gK93bndntla4SyKjaCwAnXumYs2MVl62zP7TAHV" +
       "nTZjUnOu7woh8hPWWW+5koaUDBZh\nZh4v90fsDPnlWJWcEslheR+YBbcqXC" +
       "ZPigRraQRKVudjSqD4LuKp1giZPqDZ8xrRUZJjD/mM6/Pd\nno3IfE5bxnqn" +
       "r5XDWDpzpQ5CLMfRfreL1mY1PanmkYMWTJJsze3scMhyA8yjkFvkzGYvrnv6" +
       "vD7M\nopaX1QW0rdt4LgoWp9GkM07BiCsWBcalFMeh0tRYtokgGlMPkfB+KW" +
       "+KEw2ApuOVbdfDvriPGVbQ\n/dDC5iSygOBdussC0Xa8xnSxMc6rGpy6C1pf" +
       "dKqHh4q41vSJl4LLEvVA08yX2iyfNWEN03JnK/0K\nqE4xrzdoLFHNAlXVhU" +
       "jrkpz5rkSMe7TcxTVzbOHzLpWPnlhXGwUBJ8DOaTz8DLA7g9mYMqdKKrQ7\n" +
       "Rf5KlVcOU9Z64i9XuoZEC87wIsrZ7ZNkXHBYYLIVzQJWHS50bq3ru6O6lnxj" +
       "uQ4bCyhzjYdhRlZU\nyukXCKPOxUpbmAcqCzSWL3WuKHImkOp6vV2MsVXQLx" +
       "UqOU5Oe6I9M9uVzlBGLc7yzs2mWcsHJgIf\nCRJbeA7fm4sKoHuE3UWUbNR+" +
       "dLBslVGWyoSPYpobD75tFH0AydTK6eDGM42m83cauwdmg90lq3hR\nxIlMa1" +
       "uFjI/BuZSQKOjCwUaJbGv1p00VHimmpLwIWQRjCFMzg/MswNeDdIvaLYHsdy" +
       "zpuDKE7+sN\nTAkcQ6jFrMJP1dE4IIl1VkXP8uDNKT+ie2bH7/rFupVn9Xoy" +
       "Xq7AXEAdwZNKfw/000Q30DZR1tw6\n2YbLPbQ25bjOErqB2WCb9+sjIiO1f7" +
       "LjKY5ZuCwIOCJSFDFHG14ZO6ytH+nF+gxX1t42T0yDUal+\nltOts4QrDjGp" +
       "Us80bNqgh4Jw1Gxyrub40SjmAs2WWQZRe0JhLacBFTIcez1pC21wPtZTivSj" +
       "NkQm\nWXeqUDs00ATYb9l1ytvQxpWdvGKw+szoKzYqCneR7OwuNnZruTnABi" +
       "zNpx4+dsSJS2mmNUv2eMzE\nerUStWqKOkdmT+oVNWeBCYkCEW4LSGl0nsMs" +
       "dQJIVxoondJ+uRWFDuLmbrDfNiA+1lFkGcItZlOb\nZdgmxwUnbWOM4KM89H" +
       "vmwFJroN9sTyErwP2awLF6w/ob8kilLiqgBVG2AbEwAFNCYcUbg1jfrrSZ\n" +
       "jzG6YCpeTARiVGY7q88WRdeqYiIQZ5SX49lZKCNf9RdH07JlfxZIqlXMhjit" +
       "T1oQd9qlocZjUY34\n3FGXETE3cxsvvEV+dLhjw3ab3MHOw7o3JQkKzI4UzN" +
       "nKlkQTisqZNpfOMluULYbQqwjTUz+vOWLc\nKBqKQ2C14b0gciF0SiTpyjz6" +
       "k3zNKnV8LiNVILaao1vz+ADZGrOQWF7QbInaTHXVYSGymiYLZhWD\nMTc+R8" +
       "elkOc75wDri0Cy48FVQ37msyE7Y+UllGm79Tpog7XBMLa826+CFa2J8IwDGS" +
       "dST+GQ4M+0\nLWwvh98QYzzCZ3tVSbBdlDTlsiMciRC9ojrt4NKeetHeAifo" +
       "amNZNTGJ2goxi2IqnZq5I9Q7dOMg\natNXFZnzdJ9A4xwUF72ooxwo2l5hbU" +
       "Db30PTokpyfUFxa7keXBcQtnshFzlG3EdZI0khHSPsMqJt\niLCpGuxgc9js" +
       "QA8aYwBoUBXZzwTClwId2PctRNr5Ui1xq50vm2ks9pqxDga3jXeweVB9KaJ7" +
       "cXUe\ndry979I6soZBabfG8Ck+nnpVu5axSCACz0c7PDjTKaTawjZfZQ5TOD" +
       "o3sXEiWqV4Oqv56Fz4e3cG\nRAszOYbrKS45DUUup1kgTet2zOrYdi6fyHRJ" +
       "+WVXizisUfosXi28wFTc+Wq+wpHjJJ7vd0KbA42S\ny9top5yqVCK2qG8jDL" +
       "uT6sxxTI+mx+BsfmQTMU+8yp/LqOhxANivPcB0NlOLPCMT84CdDnWCu7qr\n" +
       "7bMJqZOOAfixCRBAAZGuAB2QLXLEYzyPxnZo73R6VwQZXx14I1Cmdjr410bB" +
       "j902NZYYRTsubejQ\nZr7yYXIDHrZdlVVhOR1ksDOiQ8K1aMf5FjNdjoMjOK" +
       "+2jbUjGLM7uk2vNBppeuEslWJcVsu6AF2e\nRaZoAO6nJFzMvYMkkSWGZ5ME" +
       "LmEPyyeIQGO6xqbMmOOlWcx1i2NETj2aUIK1atDiEPuFYfez1CXk\n8ELqzg" +
       "+HY3oK9RBgzxosH6dMegYlfFIf1ey8h1ldY2ywHk/zrbxApmYZdgA5WUoMkY" +
       "rnMAVRGkUS\nnKv65X498DMB43aCbgo5cvbaAgO1JrWmiMgOu6I/a0lzL2ES" +
       "Nlbr+VnI/HI2bNRAYe9BIM0F3JlO\n/BYrD/huXdR0FjdHUz5lZhdIZSVt88" +
       "SFCtIOlEVq9EVyUCLR5mDYGG8cZ2ZaChyuoOmUWRHFpAqt\njVo1J94gIp9o" +
       "bAtu2kOZ87A2FUgVMQ5WRp/dXAooAVXPKq7NeLVsDMRsxp2V85ukJwhL6WF0" +
       "3TME\n459Nv+l0iUgJbbaeHwl0eiolcV6lFFoaNX7amosa2gu+CpWpIIondj" +
       "ZLuBlpjPdo2sYqqW568tgF\nZWOu5keMxDPUrNeBf6jiFgWAA+k1zQSYG323" +
       "j+ltHpR7KZBtIzOiuaWYcLE454VVjT1B2Qu6LFWz\n2un5eldUiyCPkrpD54" +
       "i422I2wMrCfMimawf1yXPfEE0KbCsvFbtUmlTwZuWtON+Wmvl6MV7hc60Q\n" +
       "gSoXd4t4pbQyZXdEYxXuFHSmwLxOIASs0BAS9gTYUEMmQyYWOgF9LHMWVslX" +
       "s5Tn+iW8nyioMMYO\nE5r0ptmQM7fnTcqb0x7eWJWY5qTtAK6ckeCQfvN9w7" +
       "hsMk3NQ7VFmw7einY18Qg4RBR7OaRYs8PZ\nLsfVIaPcScsmMStm+9M2jdeN" +
       "qNFrMSY0fNWFZaaeadkE7WkrlzMLb0O5Sg8z/CSEPE5AvZ3xsWsn\nbYx0wT" +
       "hKmKUqDOKi4qPFcuQMIU9D/uNLZAfMzMrarJcwZRIBD0oSy+gBAR5NB0WmDh" +
       "5qhdZ5xDLU\nPd7GTvYqHit0DbBFvay0YjsFullLZZmKARJF73ig5OylUtG+" +
       "L6s5jEzKU8m6PN2usjlztnmalise\nJdx2L1kJulgy47o/cmlJzzlv6ujrLV" +
       "YW2ZnxjjNSrHVQo4XjdlN6WrKZeiSAphVXTKQpRtDD3lUH\nzeZQTGPcw2YH" +
       "OD1IyRgrXcABDMy0d6uNqhkHjLfRuZEeFq2wAa3z0TZxfEdSfehwm1Cv2Dm0" +
       "zsUc\ni/YELOxMIvVTz9txh1PKMGNSIU7nHJmzC3w3uAQoealvnmrUHxwqTg" +
       "/ueUpabTEjzzgZEJBJ7ejt\nYQKgedhoaMmRNcERcJ2QeYiq7BgBG2IyITNL" +
       "RQfqfG7WkptEzYaPq8OOKsDZOU27OvFsL9awOOiH\nHxoB7BB8h7cWuBUtED" +
       "4gGhjmimYex4jQHiNYglcK72wP2jKu8VV52jfUoXU2cQut4YWuKZo22N9U\n" +
       "7AscQ1YBpJohOYTZOTglMNlVlkN24+AUPwb3Sx93+7k+cVywKQK4J5thbhsf" +
       "oG38MEuZTQXS3ULg\n2cpPuZwpAQ6YOV402+aUj+mVJea4gOYASQNjvWrgfA" +
       "EdNB6ZunxvnI/0eefNEkl3g1CFjMhbW4Ia\nFAvhqCwbXI5RcYmjpESJ6WLw" +
       "G/UkUwakbM5heOrGbr0xacrBPdltGpxW2maRo4PXHmt6yLQ6KxVA\nWehwYo" +
       "MRzIwQDxshZHjeAsXjyqWnXZ9M3ShU9QOuouvxgmwtXvUnZznM2VRsw4mrbE" +
       "KGnGsBWpCd\nvDyIeiFunZZYdQyRi31HBFLnBdaREczjDjDdrYa5lipvNHcM" +
       "EVOHD1EMVWgQLNfNKiqmFlL22lRJ\nGgaMtQU8nxVGUsVL1zq5ad6kZpLOty" +
       "d6Jetaq2V4yZKqRKcma4wBows0falq6zmksws1Xtds1653\njuev4T5O+LW/" +
       "2pzbBZ46NWV04j7FtKA+Yqdpz7LKvCp4li3QxYyE5vq4OO3rsLe0rRs5mlFz" +
       "Tg0v\n4bUhdEN8P/gghRzk3MaSuncPiJgxvozXorY61YcDdMILtOvEQ71frW" +
       "ZFakVj5rjhViF2ahSYptbQ\nWm8UKaXmhdwbg2JqYiZY4V4aEsa5HxkxHM4r" +
       "1xcPwrqbLJASsSqn4zxVETHMSo9jLknZFeF7lp9g\n53IPweEZA+A+DbvSlq" +
       "GOJXRXUBbTFVBaQL02c6kQZ9hme8bj5ZAA0efAIZlN12snxYHGW5iQonUD\n" +
       "ScHJKUBDcZMiiF2iKQxDb+2e9yFvWbQ8t6ocJbap2XbFMQCEdZshAfCdCqcO" +
       "OyVygU1Ihctxe1BY\nPJkhht9P1/TmOIMYcGZsTX5JYKdd5W2GaOWVc1OaTW" +
       "yM0YpYIUrX4JYrqWm5gxiBin/SbFdJZiAy\nVqbtBjkvAXZpzIIVSOfo4Qwt" +
       "pBO/2W0ZiPbo1QzBSrTT6ApsQpcTJq1XBfHSnjgMbU32HWpysakf\nkT7xxy" +
       "U9oSz+7M8FUQf3qoyWkLFHKjyKTHol7dcbmYHSEsNyH/eoTWz31T7nCJFkqq" +
       "UmE+pseWat\n5XSyDjB4+B1AWGRkkvvk4IhAdxIKdXEWjeRgeG7KTHAkGnKH" +
       "XNjiCZsDgbBolgsB1BM5SZtgq7nc\nRpzaeQRgUNsC8nipZMdWnqJnOWaDAN" +
       "qdBdZ3QnAqacpsi7SADnFtHKpmdTi0E/WoJ44gQrBAEog6\nPYIIvNbAflVE" +
       "dZPK03F98HB0dhB6XmxScJVJe+246zYuQfRUVzsbGoEkW1+m1TwvG5uSQKWk" +
       "JBhM\npxWBwX5ugUp4ZEC8KUC2HcORdt5gyfAT3z5nruMwYHAq4FqMO1mGjl" +
       "ujQaDu0IMAREik1fckJPBU\nPXXVk+KCpidYAB5icWr1QEg2Y6BqQjxuNjOd" +
       "9db9MeTDA6KQwCSbeysCWafHFU04gDjpVGZnDUG3\nSduM6MSWRHpEE3m+gU" +
       "C3HsIq7pnMWISLTT/fzouzOFE8asgGsXPjIhsWmrie0BHYHraRohKAzaoE\n" +
       "TB4NQhDDLVDDT1mNLzsWwht8Q8YWDlbiWNhS1OUI0np4kvnh6znrOxXtMPAu" +
       "A9r1wLJ7orwxenzU\n/8lH1ZJy9OazVbynSuNf1/77q18zf/0rl2PUCyJZj1" +
       "6ps/zLsdu48eMawbNEhGs1/dFR+V+597rz\nIj/9xLNFgsvFhD94+/n+0wQe" +
       "2N//hV/97t/8od/503efPWofl259KlPlqQP3N985cL8Uzd4c2icv\n7bb6T3" +
       "brkfu91LwUXK7H2f8X9aZnB59bxZIWne3ml1J2V49eLF3TuYAIV8D0KaY/O7" +
       "Q/cGm3Mf3V\nW5i+9Kv3YPiFm5P66rkXCq6luZsi1ps/8Z1/5Y9/+pfvXosZ" +
       "llndyPbZCxnvvm/x1DWKK7+vvLOq\nLw0NumVV7zptt861m+fXgohwfbynkC" +
       "//dr+fNH94aG9c2m3S/FP/D9J8T/U/GqxHH0jMMtqd8jwr\na/fKHXELd289" +
       "NNI3b+PuG/+/uXtGbq8MthnEl8sAtwnvB4eGDO1Tl3Ybe794SzXoMXs3paD3" +
       "qq4+\n8pEPDmHrYZHHtB6Glh9/hw10aH/oOWz81GArv58e7jnXyxLPUL0sDn" +
       "gvqoPr3nLX4lLS/vTz7lPd\n3Pqxf6T683+9+Gt/9Y0bD3p0JeceP3qfd4rj" +
       "J0uFT/Tv5aXrBdfp790UDvPr628NMf5dt0AGi7+8\nrov59g3c364vd6oeww" +
       "0gl9eTIL9cj15+CFIPweCUPjn4K8OnYfDS/Qf5I8X84KPgxQwE3fLJQvz/\n" +
       "AVqnlBhcJgAA");
}
